package syxxn.com.github.jwt.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import sun.security.util.Password;
import syxxn.com.github.jwt.entity.user.User;
import syxxn.com.github.jwt.entity.user.UserRepository;
import syxxn.com.github.jwt.exception.UserAlreadyExistsException;
import syxxn.com.github.jwt.payload.request.SignInRequest;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void signIn(SignInRequest signInRequest) {
        userRepository.findById(signInRequest.getEmail())
                .ifPresent(u->{
                    throw new UserAlreadyExistsException();
                });

        userRepository.save(
                User.builder()
                        .email(signInRequest.getEmail())
                        .name(signInRequest.getName())
                        .password(passwordEncoder.encode(signInRequest.getPassword()))
                        .build()
        );
    }
}
