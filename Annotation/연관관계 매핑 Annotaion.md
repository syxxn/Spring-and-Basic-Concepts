# @ManyToOne @OneToMany



N:1 관계 / 예를 들면 회원과 핸드폰의 관계라고 할 수 있다. 회원은 핸드폰을 여러개 소지할수도 있고 하나만 소지할 수도 있다. 따라서 핸드폰의 입장에서는 1:N (@OneToMany)이고, 회원의 입장에서는 N:1(@ManyToOne)인 것이다.

- 1:N 단방향 매핑의 단점
  - 엔티티가 관리하는 외래키가 다른 테이블에 있음
  - 연관관계 관리를 위해 추가로 UPDATE SQL 실행



- 일대다 단방향 매핑보다는 다대일 **양방향 매핑**을 사용하기!



```java
//읽기 전용 필드를 사용해서 양방향처럼 사용하는 방법
//default fetch type = EAGER
@ManyToOne
@JoinColumn(name = "report")
private Report report;

// ----------------------------------

//참조를 당하는 쪽에서 읽기만 가능
//default fetch type = LAZY
@OneToMany(cascade=CascadeType.ALL, mappedBy = "report")
private List<Member> members;
```



테이블 1:N 관계는 항상 N 쪽에 외래 키가 있음.

`@OneToMany`는 `@JoinColumn`을 꼭 사용해야 함. 그렇지 않으면 조인 테이블 방식을 사용하게 되서 테이블이 하나 더 생성이 되고, 운영이 어려워진다.



`mappedBy` 속성은 양방향 매핑일 때 사용하는데, 연관관계의 주인이 아니면 `mappedBy` 속성을 사용하고 연관관계 주인 필드 이름을 값으로 입력하면 된다. 이것을 사용하여 외래키가 생성되지 않도록 한다.

> 연관관계 주인은 보통 자식 테이블!

> mappedBy로 표시된 연결은 @JoinTable 또는 @JoinColumn과 같은 데이터베이스 매핑을 정의해서는 안 된다.



### 매핑을 사용하는 이유는 무엇일까?

할 때와 안 할 때의 속도차이가 다르기 때문이다!

그리고 `@OneToMany`나 `@ManyToOne`를 쓰면 Repository에 find 메소드 안써도 `user.getMembers()`처럼 솨라락 가져올 수 있다.



### JPA N + 1 문제 발생!

두 개의 엔티티가 `1:N` 관계를 가지며, JPQL로 객체를 조회할 때

1. `EAGER` 전략으로 데이터를 가져오는 경우
2. `LAZY` 전략으로 데이터를 가져온 이후에 가져온 데이터에서 하위 엔티티를 다시 조회하는 경우 



우리가 jpa로 쿼리를 짜면, `jpql`로 변환을 해준다.

> JPQL은 플랫폼에 독립적인 객체지향 쿼리 언어로서, 자바 코드에서 데이터베이스를 조회할 때 특정 SQL이나 저장 엔진에 종속되지 않게 도와준다.

 이러한 매핑을 무분별하게 사용하면 너무 많은 쿼리문을 날리게 된다.



이 문제를 해결하기 위해서는

#### 1. FetchType을 바꾸기

JPA Fetch는 `EAGER(초기)` 혹은 `LAZY(나중)` 옵션을 지정하여 연관 관계의 엔티티를 어떻게 가져올 것인지를 정한다.

+ EAGER : 자동적으로 매핑되어있는 엔티티의 데이터 가져옴.
+ LAZY : 자신이 속한 엔티티의 대한 정보만 가져오게 됨.

#### 2. BatchSize() 사용하기(where in 구문) 

+ BatchSize()를 선택하여 가져올 데이터 개수 제한해서 사용하기

- 정적임

#### 3. @Query를 직접 써서 fetch 구문 사용하기

가장 많이 쓰이는 방법이나, page를 사용할 수 없다.

#### 4. 양방향 매핑하기!



