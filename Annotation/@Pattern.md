# @Pattern



정규식을 설정하는 Valid 어노테이션이다.



```java
	@NotBlank
    @Pattern(regexp = "[a-zA-Z1-9]{6,13}", message = "비밀번호는 영어와 숫자를 포함하여 6~13자리 이내로 입력하시오.")
    String password;
```



위와 같이 사용하면 `[]` 안에 사용 가능한 문자들을 넣고, `{}` 안에 문자열의 최소, 최대 길이를 설정해 주면 된다.



