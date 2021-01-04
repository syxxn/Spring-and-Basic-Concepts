package syxxn.com.github.jwt.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
        // getAuthentication() : 토큰 값을 반환한다.
    }

    public String getUserEmail() {
        return this.getAuthentication().getName();
        //getAuthentication을 호출해서 토큰을 가져온 후, 내가 암호화 한 값(토큰에 넣은 id값)을 가져온다.
    }

}
