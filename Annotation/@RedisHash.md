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
public class RefreshToken{
    
    @Id
    //유저의 고유 값
    private String email;

    @Indexed //레디스에 값을 직관적으로 저장하기 위해서
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





### @Indexed

인덱싱을 사용하기 위한 어노테이션

> 인덱스(색인)는 검색 속도를 높이기 위한 데이터 구조이다. 인덱스는 일반적으로 키-필드로 이루어져 있고 테이블에 대한 세부 정보를 가지지 않는다. 별도의 세부 정보의 이용없이 키 값을 기초로 하기 때문에 검색과 정렬속도를 향상시킨다. 