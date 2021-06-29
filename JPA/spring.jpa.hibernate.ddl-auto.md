# spring.jpa.hibernate.ddl-auto



Hibernate는 ORM(Object Relation Mapping) 프레임워크이다. 

Hibernate는 특정 클래스에 매핑되어야 하는 데이터베이스의 테이블에 대한 관계 정의가 되어 있는 XML 파일의 메타데이터로 **객체관계 매핑을 간단하게 수행**시킨다.

Hibernate를 사용하면 데이터베이스가 변경되더라도 SQL 스크립트를 수정하는 등의 작업을 할 필요가 없고, 많은 데이터베이스를 지원한다.

> Application에서 JPA 인터페이스를 사용하면 Hibernate와 같은 곳에서 JDBC를 사용하여 RDB에서 정보를 가져와 사용하는 것이다.

![image info](https://gmlwjd9405.github.io/images/spring-framework/spring-jdbc-architecture.png)



properties에 작성하는 `spring.jpa.hibernate.ddl-auto`에서는 사용할 수 있는 옵션 5개가 있다.

+ `none` : 대부분의 데이터베이스의 default 값으로서, 데이터베이스의 구조는 변경되지 않는다는 의미이다.

+ `update` : 변경된 스키마만 적용한다.

+ `validate` : 변경된 스키마가 있는지 확인**만** 한다. 만약 변경이 있다면 Application을 종료한다.

+ `create` : 매번 데이터베이스를 생성하지만, 닫을 때 삭제하지 않는다.

+ `create-drop` : 데이터베이스를 만든 다음 SessionFactory가 닫힐 때 삭제한다.

  > H2에서는 create-drop이 default이기 때문에 명시적으로 쓰지 않아도 무관하다.