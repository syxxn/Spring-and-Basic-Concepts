# @Json_



### @JsonFormat

날짜/시간 값을 직렬화할 때 기본을 설정한다.

```java
@JsonFormat(shape = JsonFromat.Shape.STRING, pattern = "dd-M-yyyy")
public Date eventDate;
```



### @JsonManagedReference

매핑 관계에서 부모 클래스측에 사용한다.

```java
@ManyToOne
@JsonManagedReference
@JoinColumn(name = "category_id")
private Category category;
```



### @JsonBackReference

매핑 관계에서 자식 클래스측에 사용한다.

> database에 다른 테이블의 pk를 가지고 있는 테이블을 자식이라 함.

```java
@ManyToOne
@JsonManagedReference
@JoinColumn(name = "user_email")
private User user;
```

