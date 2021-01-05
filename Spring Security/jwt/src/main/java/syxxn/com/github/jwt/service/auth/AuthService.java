package syxxn.com.github.jwt.service.auth;

import syxxn.com.github.jwt.payload.request.SignInRequest;
import syxxn.com.github.jwt.payload.response.AccessTokenResponse;
import syxxn.com.github.jwt.payload.response.TokenResponse;

public interface AuthService {
    TokenResponse signIn(SignInRequest signInRequest);
    AccessTokenResponse tokenRefresh(String recievedToken);
}
