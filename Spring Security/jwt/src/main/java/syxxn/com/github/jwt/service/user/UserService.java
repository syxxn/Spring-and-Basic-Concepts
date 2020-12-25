package syxxn.com.github.jwt.service.user;

import syxxn.com.github.jwt.payload.request.SignInRequest;

public interface UserService {
    void signIn(SignInRequest signInRequest);
}
