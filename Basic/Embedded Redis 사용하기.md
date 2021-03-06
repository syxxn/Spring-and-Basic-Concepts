# Embedded Redis 사용하기



Embedded Redis를 사용하면 인메모리 DB가 된다. 이말은 즉슨, 서버가 꺼지면 데이터가 소멸되기 때문에 보통은 테스트 용으로 사용한다.



build.gradle에 의존성 주입

```java
implementation 'mysql:mysql-connector-java'
implementation 'org.springframework.boot:spring-boot-starter-data-redis'
implementation 'it.ozimov:embedded-redis:0.7.3'
```



EmbeddedRedis를 사용하면 redis 오류가 날 때가 있다.

```
The Windows version of Redis allocates a memory mapped heap for sharing with the forked process used for persistence operations. In order to share this memory, Windows allocates from the system paging file a portion equal to the size of the Redis heap. At this time there is insufficient contiguous free space available in the system paging file for this operation (Windows error 0x5AF). To work around this you may either increase the size of the system paging file, or decrease the size of the Redis heap with the --maxheap flag.
```

따라서 heap의 max 크기를 정해준다.

```java
server = RedisServer.builder()
                .setting("maxheap 512M")
                .build();
```



EmbeddedRedisConfig

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


@Configuration
@Profile("local") // 로컬에서 돌릴 때만 사용
public class EmbeddedRedisConfig {

    private final RedisServer redisServer;

    public EmbeddedRedisConfig(@Value("${spring.redis.port}") int redisPort) {
        this.redisServer = RedisServer.builder()
                .setting("maxheap 128M")
                .build();
    }

    @PostConstruct
    public void runRedis() {
        redisServer.start();
    }

    @PreDestroy
    public void stopRedis() {
        redisServer.stop();
    }

}
```



RedisRepositoryConfig

```java
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


@EnableRedisRepositories
@Configuration
public class RedisRepositoryConfig {

    @Value("${spring.redis.host}")
    private String redisHost;

    @Value("${spring.redis.port}")
    private String redisPort;

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory(redisHost, Integer.parseInt(redisPort));
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory());
        return redisTemplate;
    }

}
```