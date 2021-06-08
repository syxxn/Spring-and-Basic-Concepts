# Spring boot properties setting

path : ../src/main/resources



#### application.properties

+ Spring bot에서 기본적으로 key-value 형식을 사용하여 property를 설정할 수 있다.

+ properties 파일은 단일 구성이다.

```properties
# 주석주석
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver #1
spring.datasource.username=${DB_USERNAME} #2
spring.datasource.password=${DB_PASSWORD}
spring.datasource.url=${DB_URL}

spring.jpa.generate-ddl=true

auth.jwt.secret=${JWT_SECRET}
```

+ `#1`처럼 값을 직접 넣을 수도 있고, `#2`처럼 시스템 속성 또는 환경 변수의 내용을 참조하여 사용할 수도 있다.



#### application.yml

+ yml이란, 계층적 구성 데이터를 지정하기 편리하고, 사람이 쉽게 읽을 수 있는 데이터 직렬화 양식을 말한다.
+ yml 문법은 상대적으로 이해하기 쉽고, 가독성이 좋도록 디자인되었다.
+ JSON은 yaml의 일종이다.

```yaml
# 주석주석
spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    username: ${DB_USERNAME}
    password: ${DB_PASSWORD}
    url: ${DB_URL}
  jpa:
    generate-ddl: true

auth:
  jwt:
    secret: ${JWT_SECRET}
```

1. properties와 비교하여 **가독성**이 좋다.

2. properties와 마찬가지로 `#`을 사용하여 주석을 처리할 수 있다.

#### 사용법

`@Value`를 사용하여 환경변수에 있는 값을 가져올 수 있다.

```java
import org.springframework.beans.factory.annotation.Value;

public class A {
    
    @Value("${auth.jwt.secret}")
    private String secretKey;
    
}
```

