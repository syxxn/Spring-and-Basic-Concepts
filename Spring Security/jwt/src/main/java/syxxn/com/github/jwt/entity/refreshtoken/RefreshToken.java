package syxxn.com.github.jwt.entity.refreshtoken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Id;

@Getter
@AllArgsConstructor
@RedisHash(value = "refresh_token")
public class RefreshToken {

    @Id
    private String email;

    @Indexed //레디스에 값을 직관적으로 저장하기 위해서
    private String refreshToken;

    @TimeToLive//리프레시토큰 유효기간
    private Long refreshExp;

    public RefreshToken update(String refreshToken, Long refreshExp) {
        this.refreshToken = refreshToken;
        this.refreshExp = refreshExp;
        return this;
    }
}
