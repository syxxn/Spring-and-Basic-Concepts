# ResponseStatus



- 메소드를 @ResponseStatus에 어노테이션을 부여하고 value에 상태 코드를 지정하면, 그 응답의 상태 코드를 지정할 수 있다.
- 아무것도 지정하지 않으면 200 OK가 반환된다.



보통 성공 응답 코드는 Controller에 추가하고,

```java
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public void addMember(@RequestBody MemberRequest memberRequest){
    memberService.addMember(memberRequest);
}
```



예외 처리는 따로 빼서 사용한다.

```java
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "User is Not a Member of the Team")
public class UserNotMemberException extends RuntimeException {
}
```

