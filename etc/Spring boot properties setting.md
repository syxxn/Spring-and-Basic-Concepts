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
+ 스프링 부트 2.0부터는 프로퍼티명에 소문자나 케밥 표기법(-)만 사용할 수 있다.



#### application.yml
+ 원래 YAML은 'YAML은 마크업 언어가 아니다(YAML Ain't Markup Language)'라는 뜻으로 핵심이 문서 마크업이 아닌 데이터 중심에 있다는 것을 보여준다. 그에 맞게 가독성이 좋으며 문법이 이해하기 수월하도록 작섣된 언어이다.

+ 기존에는 Properties 파일을 많이 사용했지만 최근에는 표현의 한계로 YAML 파일을 더 많이 사용한다.
+ yml이란, 계층적 구성 데이터를 지정하기 편리하고, 사람이 쉽게 읽을 수 있는 데이터 직렬화 양식을 말한다.
+ yml 문법은 상대적으로 이해하기 쉽고, 가독성이 좋도록 디자인되었다.
+ JSON은 yaml의 일종이다.
+ 만약 `.properties`와 `.yml` 파일 둘 다 생성되어 있다면 `.yml`만 오버라이드 되어 적용된다.

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

#### 프로필 설정
1. 한 파일로 관리하기 (---를 기준으로 설정 값을 나눈다)
  ```
  spring:
    profile: test
  server:
    port : 8080
  ---
  spring:
    profile: local
  server:
    port: 8081
  ```
2. 여러 파일 생성하기
  `application-{profile}.yml` {profile}에 원하는 프로파일 값으로 YAML 파일을 추가하면 애플리케이션 실행 시 지정한 프로파일 값을 바탕으로 실행된다.
  ```
  application-test.yml
  application-local.yml
  ```

#### 사용법

1. `@Value`

  ```java
  import org.springframework.beans.factory.annotation.Value;

  public class A {
    
      @Value("${auth.jwt.secret}") //환경변수에 있는 값을 하나씩 가져올 수 있다.
      private String secretKey;
    
  }
  ```
2. `@ConfigurationProperties`
  ```
    fruit:
      list:
        -name:
         color:
         
     ---
     
     @Component // 이걸 해야 사용하려는 곳에서 의존성 주입이 가능하다.
     @ConfigurationProperties("fruit") // 접두사가 fruit인 프로퍼티 키값을 읽어와서 필드값에 매핑한다.
     public class FruitProperty {
        private List<Map> list; //List<Map>을 사용하는 것보다 POJO 타입으로 사용하는 것이 좋다.(클래스를 따로 파는 것)
     }
     
     ---
     
     public class PropertyTest {
        @Autowired
        FruitProperty fruitProperty;
        
        public void test() {
          List<Map> fruitData = fruitProperty.getList();
        }
     }
  ```
