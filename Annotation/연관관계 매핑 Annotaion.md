# @ManyToOne @OneToMany



N:1 관계 / 예를 들면 회원과 핸드폰의 관계라고 할 수 있다. 회원은 핸드폰을 여러개 소지할수도 있고 하나만 소지할 수도 있다. 따라서 핸드폰의 입장에서는 1:N (@OneToMany)이고, 회원의 입장에서는 N:1(@ManyToOne)인 것이다.

- 1:N 단방향 매핑의 단점
  - 엔티티가 관리하는 외래키가 다른 테이블에 있음
  - 연관관계 관리를 위해 추가로 UPDATE SQL 실행



- 일대다 단방향 매핑보다는 다대일 **양방향 매핑**을 사용하기!



```java
//읽기 전용 필드를 사용해서 양방향처럼 사용하는 방법
@ManyToOne
@JoinColumn(name = "report")
private Report report;

// ----------------------------------

//참조를 당하는 쪽에서 읽기만 가능
@OneToMany(cascade=CascadeType.ALL, mappedBy = "report")
private List<Member> members;
```



테이블 1:N 관계는 항상 N 쪽에 외래 키가 있음.

`@OneToMany`는 `@JoinColumn`을 꼭 사용해야 함. 그렇지 않으면 조인 테이블 방식을 사용하게 되서 테이블이 하나 더 생성이 되고, 운영이 어려워진다.



### 매핑을 사용하는 이유는 무엇일까?

할 때와 안 할 때의 속도차이가 다르기 때문이다!

그리고 `@OneToMany`나 `@ManyToOne`를 쓰면 Repository에 find 메소드 안써도 `user.getMembers()`처럼 솨라락 가져올 수 있다.