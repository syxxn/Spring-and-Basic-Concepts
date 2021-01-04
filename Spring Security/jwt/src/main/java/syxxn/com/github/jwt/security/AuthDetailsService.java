package syxxn.com.github.jwt.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import syxxn.com.github.jwt.entity.user.UserRepository;
import syxxn.com.github.jwt.exception.UserNotFoundException;

@RequiredArgsConstructor
@Service
//AuthDetailsService -> AuthDetails
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    //사용자의 이름으로 사용자를 싣다
    @Override
    public AuthDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        //userEmail로 유저를 찾고 AuthDetails에 들어가서 정보를 확인한다.
        return userRepository.findById(userEmail)
                .map(AuthDetails::new)
                .orElseThrow(UserNotFoundException::new);
    }

}
