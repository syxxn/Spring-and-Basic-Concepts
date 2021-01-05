package syxxn.com.github.jwt.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import syxxn.com.github.jwt.payload.request.SignInRequest;
import syxxn.com.github.jwt.payload.response.AccessTokenResponse;
import syxxn.com.github.jwt.payload.response.TokenResponse;
import syxxn.com.github.jwt.service.auth.AuthService;

@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TokenResponse signIn(SignInRequest signInRequest) {
        return authService.signIn(signInRequest);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public AccessTokenResponse tokenRefresh(String receivedToken) {
        return authService.tokenRefresh(receivedToken);
    }

}
