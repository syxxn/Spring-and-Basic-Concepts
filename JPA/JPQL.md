# JPQL

> Java Persistence Query Language



+ JPA는 SQL을 추상화한 JPQL이라는 객체 지향 쿼리 언어를 제공한다. JPQL을 분석하고 SQL을 생성한 후 DB에서 조회한다.
+ SQL과 문법이 유사하고, SELECT, FROM, WHERE, GROUP BY, HAVING, JOIN 등을 지원한다.
+ JPQL은 엔티티 객체를 대상으로 쿼리를 질의하고, SQL은 데이터베이스 테이블을 대상으로 쿼리를 질의한다.



```java
EntityManager entityManager;

TypedQuery<T> query = entityManager.createQuery("", T.class);
```



+ Native SQL : JPA가 SQL을 직접 사용할 수 있는 기능을 제공하는 SQL

```java
List<T> ts = entityManager.createNativeQuery("", T.class)
    		 .getResultList();
```

