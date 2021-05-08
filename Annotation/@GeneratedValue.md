# @GeneratedValue



### strategy = GenerationType.IDENTITY
+ PK 생성 규칙을 나타냄
+ 기본 키 생성을 데이터베이스에 위임
+ 즉, id값을 null로 하면 DB가 알아서 AI(auto increment)해준다 > mysql 등
+ id값을 미리 설정하지 않고 insert query를 날리면 그 때 id 값을 세팅한다.
+ 즉, id 값은 DB에 값이 들어간 이후에 알 수 있다.
+ 모아서 insert 하는 것이 불가능하다.

+ 스프링 부트 2.0에서는 `GenerationType.IDENTITY` 옵션을 추가해야만 auto_increment가 된다

### strategy = GenerationType.Auto

+ 기본 설정 값
+ 다른 전략을 IDENTITY, SEQUENCE, TABLE 중 적절한 것 하나로 지정한다.
> Spring Boot 2.0으로 넘어오면서 JPA의 GeneratedValue의 기본 설정이 SEQUENCE방식으로 되어 있다.
> MySQL은 SEQUENCE 방식을 지원하지 않기 때문에 AUTO를 사용하면 TABLE 전략을 사용한다.
