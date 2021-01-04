# @Bean vs @Component

`@Bean`과 `@Component` 모두 Spring Container에 Bean을 등록하도록 하는 어노테이션이다.



#### @Bean

@Bean 어노테이션의 경우 개발자가 직접 제어가 불가능한 외부 라이브러리 등을 bean으로 만드려고 할 때 사용된다.

```java
@Bean(name=)
public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
```

> name을 이용하면 자신이 원하는 id로 bean을 등록할 수 있고, 별도로 설정하지 않은 경우에는 메소드의 이름을 CamelCase로 변경한 것이 bean의 id가 된다.



해당 메소드의 자료형을 호출함으로써 의존성을 주입할 수 있다.



#### @Component

@Component 어노테이션의 경우 개발자가 직접 작성한 class를 bean으로 등록하기 위한 어노테이션이다.

```java
@Component(value=)
public class AuthenticationFacade {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
        
    }

    public String getUserEmail() {
        return this.getAuthentication().getName();
    }

}
```

> value를 이용하여 bean의 이름을 설정할 수 있으며, 이 역시 추가 정보가 없다면 class의 이름을 CamelCase로 변경한 것이 Bean id로 사용된다.



@Service, @RestController 등은 @Component의 자식이라 할 수 있다.



@Component를 사용한 Bean의 의존성 주입은 @AutoWired 어노테이션을 이용할 수도 있고,

`@NoArgsConstuctor`, `@AllArgsConstructor`, `@RequiredArgsConsturctor` 등을 이용할 수도 있다.