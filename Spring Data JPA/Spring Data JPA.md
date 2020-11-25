# Spring Data JPA



Spring Data JPA는 JPA(Java Persistence API)를 편리하게 사용하도록 도와주는 기술이다.

> **JPA**
>
> Java  자바 
>
> Persistence 영속성 : 사라지지 않는 데이터의 특성
>
> API  (기능 정도로 생각하면 될 듯)



### 그렇다면 JPA란 무엇일까?

+ JPA는 기존의 반복 물론이고, 기본적인 SQL도 직접 만들어서 실행해준다.
+ JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환할 수 있다.
+ JPA를 사용하면 개발 생산성을 크게 높일 수 있다.





### Spring Data JPA는 

+ 인터페이스를 통해 기본적인 **CRUD를 제공**한다.
+ `findByName()`, `findByEmail()`처럼 메소드 이름만으로 조회 기능을 제공한다.
+ 페이징 기능을 자동으로 제공한다.



Spring Data JPA를 사용하기 위해서는 

+ build.gradle에 추가하기

  ` implementation 'org.springframerok.boot:spring-boot-starter-data-jpa'`

+ resource/application.어쩌구에 추가하기

  ```javascript
  spring.datasource.url=jdbc:h2:tcp://localhost/~/test
  spring.datasource.driver-class-name=org.h2.Driver
  spring.jpa.show-sql=true -- JPA가 생성하는 SQL을 출력한다
  spring.jpa.hibernate.ddl-auto=none -- JPA는 테이블을 자동으로 생성하는 기능을 제공하는데 `none`을 사용하면 해당 기능을 끈다
  ```

  



실무에서는 JPA와 스프링 데이터 JPA를 기본으로 사용하고, 복잡한 동적 쿼리는 `Querydsl`이라는 라이브러리를 사용하면 된다.