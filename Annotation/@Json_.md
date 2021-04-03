# @Json_



### @JsonFormat

날짜/시간 값을 직렬화할 때 기본을 설정한다.

```java
@JsonFormat(shape = JsonFromat.Shape.STRING, pattern = "dd-M-yyyy")
public Date eventDate;
```



순환 참조를 막기 위해 아래의 것들을 사용한다.

### @JsonManagedReference


매핑 관계에서 부모 클래스측에 사용한다. 
> @OneToMany인 경우


```java
@OneToMany(cascade=CascadeType.ALL, mappedBy = "report") //부모@OneToMany(cascade=CascadeType.ALL, mappedBy = "report") //부모
@JsonManagedReference
private List<Member> members;
```



### @JsonBackReference

매핑 관계에서 자식 클래스측에 사용한다.

> database에 다른 테이블의 pk를 가지고 있는 테이블을 자식이라 함.
> @ManyToOne인 경우 

```java
@ManyToOne //자식
@JsonBackReference
@JoinColumn(name = "report")
private Report report;
```

