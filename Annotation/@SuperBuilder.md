# @SuperBuilder

+ Lombok 1.18.2 이후부터 사용할 수 있는 어노테이션으로 상속되는 클래스의 Builder를 생성할 수 있다.
+ 부모 클래스와 자식 클래스 모두에게 `@SuperBuilder` 어노테이션을 붙이면 된다.



```java
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse {

    private long totalElements;

    private int totalPages;

}

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantsResponse extends PageResponse {

    private List<ApplicantsInformationResponse> applicantsInformationResponses;

    @Builder
    public ApplicantsResponse(Integer totalElements, Integer totalPages, List<ApplicantsInformationResponse> applicantsInformationResponses) {
        super(totalElements, totalPages);
        this.applicantsInformationResponses = applicantsInformationResponses;
    }
}
```

> @Builder를 사용했을 때



```java
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class PageResponse {

    private long totalElements;

    private int totalPages;

}

@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ApplicantsResponse extends PageResponse {

    private List<ApplicantsInformationResponse> applicantsInformationResponses;

}
```

> @SuperBuilder를 사용할 때

