# Null Check Validation



별도의 조건을 설정해 주기 위해서는 `build.gradle`에 추가해 주어야 한다.

```java
implementation 'org.springframework.boot:spring-boot-starter-validation'
```



validation 어노테이션은 @Valid 없이는 동작하지 않고, null이 들어오면 400을 띄운다.

> @NonNull은 lombok 어노테이션으로서, null이 들어오면 500을 내보낸다.



### @NotNull

**`null`만 허용하지 않는다**. 따라서 `""`이나 `" "`는 허용하게 된다.

그렇기 대문에 만약 `""`(초기화된 문자열)이나 `" "`(공백)이 들어가면 안될 때는 사용하면 안된다.

즉, 초기화나 공백의 값이 들어왔을 때는 괜찮지만, Null로 들어온 경우에는 오류가 나도록 해야 할 때 사용하는 어노테이션이다.

> Entity 컬럼에 붙여도 적용된다. `nullable=false`와 달리 유효성 검사를 해주기 때문에 더 안전할 수도 있다.



### @NotEmpty

**`null`과 `""` 둘 다 허용하지 않게 한다**.

즉, @NotEmpty에서는 `null`과 `""`는 막히되, `" "`는 허용이 된다.



### @NotBlank

**`null`, `""`, `" "` 모두를 허용하지 않는다**.

세 어노테이션 중 가장 validation(검증) 강도가 높다. 값이 들어와야만 인정!



이러한 Validation을 용도 및 상황에 맞게 사용한다면 사용자의 오류나 시스템의 오류를 최소화 할 수 있다.