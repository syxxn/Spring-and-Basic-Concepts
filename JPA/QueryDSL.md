# QueryDSL

SQL, JPQL을 코드로 작성할 수 있도록 도와주는 빌더 API를 QueryDSL이라고 한다.



[사용법]

1. Config 설정하기

```java
@Configuration
public class QueryDSLConfig {

    @PersistenceContext
    private EntityManager entityManager;

    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
```



2. QuerydslRepositorySupport 구현체 만들기

```java
@RequiredArgsConstructor
@Repository
public class ReportRepositorySupport extends QuerydslRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;

    public Page<Report> findAllByType(Type type, Pageable pageable) {
        QueryResults<Report> results = jpaQueryFactory
                .select(report)
                .from(report)
                .where(report.status.isSubmitted.eq(true)
                        .and(report.status.isAccepted.eq(true)))
                .where(eqGrade(grade)
                        .and(eqType(type))
                        .and(eqAccess())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .orderBy(report.id.desc())
                .fetchResults();

        return new PageImpl<>(results.getResults(), pageable, results.getTotal());
    }

}
```

