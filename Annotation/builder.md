### @Builder

@Builder를 사용하는 이유는직관적인 코드를 짜기 위함이다.



@_ArgsConstructor를 사용해서 값을 넣어주면, 필드의 순서를 외워야 한다.

```java
User user = new User("id","password","girl","010-2222-8888");
```



@Builder를 사용하면, 필드를 직접 지정하여 값을 넣어주기 때문에 순서를 외울 필요가 없고, 실수를 줄일 수 있다.

```java
User.builder
	.id("id")
	.password("password")
	.gender("girl")
	.phoneNum("010-2222-8888")
	.build
```



+ @Builder를 사용할 때는 @NoArgsConstructor와 @AllArgsConstructor를 사용해야 한다.

  > @NoArgsConstructor는 테스트에서 ObjectMapper를 사용하기 위해서 붙여야 하는 것이다.
  >
  > @Builder를 붙이면 클래스 내부에 Builder 클래스가 만들어진다. `[클래스].builder().build()`로 사용하면 Builder 클래스 내부에 값이 들어가는 것이다. 이 값을 원래의 클래스로 올려 보내주기 위해서 @AllArgsConstructor가 필요하다. 

