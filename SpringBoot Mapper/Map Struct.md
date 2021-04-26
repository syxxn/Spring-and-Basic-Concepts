# Map Struct

+ DTO와 Entity 간 객체 Mapping을 편하게 도와주는 라이브러리이다.
+ 컴파일 시 오류를 확인할 
+ 기본적으로 이름이 같은 것 끼리는 매핑을 해주는데, 이름이 다른 경우에는 따로 설정을 해줘야 한다.

+ builder.build를 사용하는 것이 길거나 복잡한 경우 mapper를 사용한다.



```java
dependencies {
   ...
    compile('org.mapstruct:mapstruct:1.3.0.Beta2')
    compileOnly('org.mapstruct:mapstruct-processor:1.3.0.Beta2')
    annotationProcessor('org.mapstruct:mapstruct-processor:1.3.0.Beta2')
		...
}
```



```java
@MapperConfig(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE) 
public interface MapStructConfig {
}
```

+ `componentModel="spring"`이 있어야 spring bean이 등록된다.
+ `unmappedSourcePolicy=ReportingPolicy.IGNORE`은 원래 targer들 중 매핑이 안된 것이 있으면 원래 오류를 띄우는데, 그것을 안 띄우겠다는 의미이다.  `ignore`은 매핑되지 않도록 하기 위해 설정하는 것이다.



```java
@Mapper(config = MapStructConfig.class)
public interface ReportMapper {

    @Mapping(target = "id", ignore = true) 
    @Mapping(target = "comment", ignore = true)
    @Mapping(target = "isAccepted", defaultValue = "false", ignore = true)
    @Mapping(target = "reportType.type", source = "request.type")
    @Mapping(target = "reportType.field", source = "request.field")
    @Mapping(target = "reportType.access", source = "request.access") //targer은 
    @Mapping(target = "reportType.grade", source = "request.grade")
    @Mapping(target = "languages", ignore = true)
    Report requestToEntity(ReportRequest request, User user);

    @Mapping(source = "report.reportType.type", target = "type")
    ReportResponse entityToResponse(Report report);

    @Mapping(source = "report.reportType.type", target = "type")
    @Mapping(source = "report.reportType.field", target = "field")
    @Mapping(source = "report.reportType.access", target = "access")
    @Mapping(source = "report.reportType.grade", target = "grade")
    @Mapping(source = "report.reportFile.fileName", target = "fileName")
    @Mapping(source = "report.reportFile.id", target = "fileId")
    @Mapping(source = "languages", target = "languages")
    @Mapping(source = "comments", target = "comments")
    @Mapping(source = "member", target = "member")
    @Mapping(source = "report.createdAt", target = "createdAt")
    ReportContentResponse entityToContentResponse(Report report, Boolean isMine,List<String> languages,
                                                  List<ReportCommentsResponse> comments, List<MemberResponse> member);
}
```



```java
@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService {

    public Long createReport(ReportRequest request) {
        Report report = reportMapper.requestToEntity(request, userFactory.createAuthUser());

        request.getLanguages().stream()
                .map(language -> languageMapper.requestToEntity(language, report))
                .forEach(language -> report.addLanguage(language));

        report.setReportType(reportTypeMapper.requestToEntity(request, report));
        report.addMember(memberMapper.getEntity(userFactory.createAuthUser(), report));

        return reportRepository.save(report).getId();
    }

}
```

**reportTypeMapper.requestToEntity(request, report)** 이런식으로 사용하면 된다.