# @RedisHash



의존성

```java
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
```



```java
@Configuration
@EnableRedisRepositories
public class RedisConfig {
}
```



```java
@Getter
@RedisHash
@AllArgsConstructor
public class Redis{
    
    @Id
    //유저의 고유 값
    private String email;

    @Indexed
    private String refreshToken;

    @TimeToLive
    //refresh token의 유효기간
    private Long refreshExp;
    
}
```



```java
public interface RedisRepository extends CrudRepository<Redis,String>{
}
```





Redis Repository로 이용하기 위해서 `@RedisHash`을 이용해 key를 설정해 주어야 한다. 최종적으로 Redis에 들어가는 key는 @RedisHash의 value + @Id가 붙어있는 멤버변수이다.