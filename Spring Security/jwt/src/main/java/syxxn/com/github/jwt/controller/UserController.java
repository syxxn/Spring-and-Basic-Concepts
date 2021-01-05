package syxxn.com.github.jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import syxxn.com.github.jwt.payload.request.SignInRequest;
import syxxn.com.github.jwt.service.user.UserService;

@RequestMapping("/user")
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void signIn(@RequestBody SignInRequest signInRequest) {
        userService.signIn(signInRequest);
    }

}
