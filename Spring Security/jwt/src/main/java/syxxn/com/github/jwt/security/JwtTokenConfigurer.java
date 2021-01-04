package syxxn.com.github.jwt.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class JwtTokenConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void configure(HttpSecurity httpSecurity) {
        JwtTokenFilter tokenFilter = new JwtTokenFilter(jwtTokenProvider); //미리 만들어 둔 토큰 필터를 생성한다
        httpSecurity.addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter.class);
        //addFilterBefore이라고 되어있는 부분은 스프링 부트에서 기본적으로 지원하는 필터 이외에
        //사용자가 지정한 필터를 추가해주는 역할을 한다.
    }

}
