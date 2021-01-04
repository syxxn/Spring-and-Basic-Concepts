package syxxn.com.github.jwt.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenFilter extends GenericFilterBean {

    private final JwtTokenProvider jwtTokenProvider;


    // 사용자가 요청을 하면 필터 거쳐서 컨트롤러로 감 / 컨트롤러를 실행하고 돌아감
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 요청과 응답을 동시에 받는다.

        String token = jwtTokenProvider.resolveToken((HttpServletRequest) request);

        if(token != null && jwtTokenProvider.validateToken(token)){//token이 null이 아니고 유효하다면
            Authentication auth = jwtTokenProvider.getAuthentication(token); //인증 객체를 생성하고
            SecurityContextHolder.getContext().setAuthentication(auth);
            //컨트롤러 들어가기 전에 보안관친구(SecurityContextHolder) 가방에 인증객체를 담음
        }
        chain.doFilter(request, response); //적용된 필터와 함께 가방을 넘김김
    }
}
