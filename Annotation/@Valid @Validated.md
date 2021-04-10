# @Valid @Validated



@Valid와 @Validated 모두 유효성 검사를 하는 어노테이션이다.



```java
@PutMapping
@ResponseStatus(HttpStatus.NO_CONTENT)
public void updatePassword(@RequestBody @Validated PasswordRequest request) {
        accountService.updatePassword(request.getPassword());
}
```

> 위처럼 해도 request의 속성 제약 조건이 맞는지 검사할 수 있다. 하지만 @Validated는 원하는 속성만 유효성 검사를 하고 싶은 경우에 사용하는 것이 정확하다.

https://velog.io/@damiano1027/Spring-Valid-Validated%EB%A5%BC-%EC%9D%B4%EC%9A%A9%ED%95%9C-%EB%8D%B0%EC%9D%B4%ED%84%B0-%EC%9C%A0%ED%9A%A8%EC%84%B1-%EA%B2%80%EC%A6%9D



그룹을 설정하여 필요한 것만 유효성 검사를 하고 싶을 때는 @Validated, 요청 전체를 검사하고 싶을 때는 @Valid를 사용하면 된다.

