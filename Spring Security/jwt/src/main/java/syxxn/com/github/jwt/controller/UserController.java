package syxxn.com.github.jwt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import syxxn.com.github.jwt.payload.request.SignInRequest;
import syxxn.com.github.jwt.service.user.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    void signIn(@RequestBody SignInRequest signInRequest){
        userService.signIn(signInRequest);
    }

}
