package syxxn.com.github.jwt.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponse {

    private String accessToken;

    private String refreshToken;

    private Long refreshExp;

}
