package syxxn.com.github.jwt.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import syxxn.com.github.jwt.exception.InvalidTokenException;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider { //토큰 생성을 시작해봅시다

    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Value("${auth.jwt.exp.access}")
    private Long accessTokenExpiration;

    @Value("${auth.jwt.exp.refresh}")
    private Long refreshTokenExpiration;

    @Value("${auth.jwt.header}")
    private String header;

    @Value("${auth.jwt.prefix}")
    private String prefix; // 이 안에 'bearer'이라는 문자열이 있음

    private final AuthDetailsService authDetailsService;

    public String generateAccessToken(String email) { //access 토큰을 만들어볼겁니다.
        return Jwts.builder()
                .setIssuedAt(new Date()) //생성일 (현재 날짜 및 시간)
                .setSubject(email) // 암호화할 문자열을 알려준다.
                .setExpiration(new Date(System.currentTimeMillis() + accessTokenExpiration * 1000))
                //currentTimeMillis()는 시간을 밀리세컨드 단위(1초 = 1000밀리세컨드)로 알려주고
                //accessTokenExpiration은 세컨드 단위로 저장했기 때문에 단위를 맞춰주기 위해서 *1000을 한 것임
                .claim("type", "access_token") //토큰의 유형을 정해줌
                .signWith(SignatureAlgorithm.HS256, secretKey)
                //암호화 종류와 어떤 시크릿키로 암호화할 것인지 정해준다.
                //시크릿키는 공개키, 개인키와는 아예 종류가 다름. / 암호화하기 위한 키
                .compact(); //만들겠다!
    }

    public String generateRefreshToken(String email) { //claim 빼고 코드 내용은 generateAccessToken과 동일
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + refreshTokenExpiration * 1000))
                .claim("type", "refresh_token")
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String resolveToken(HttpServletRequest request) { //HttpServletRequest는 http요청 자체를 말함(header, body 다 있는)
        String bearerToken = request.getHeader(header); //key 값이 authorization인 value를 가져옴 //JWT에서는 'bearer
        if (bearerToken != null && bearerToken.startsWith(prefix)) {
            return bearerToken.substring(7);
            //기본적으로 토큰 앞에 'bearer'이라는 단어가 들어가기 때문에 그 단어를 제외한 실제 순수 토큰을 반환한다.
        }
        return null;
    }

    public boolean validateToken(String token) { //토큰이 유효한지 검사한다
        try {
            Jwts.parser().setSigningKey(secretKey) //환경변수에 저장해놓은 secretkey를 이용하여 해석
                    .parseClaimsJws(token).getBody().getSubject();// body에서 고유 정보를 가져옴
            return true;
        } catch (Exception e) {
            throw new InvalidTokenException(); //token 형식이 잘못됐거나, secretkey가 잘못된 경우
        }
    }

    public Authentication getAuthentication(String token) { //토큰을 받아서 인증 객체를 만듦
        AuthDetails authDetails = authDetailsService.loadUserByUsername(getEmail(token));
        return new UsernamePasswordAuthenticationToken(authDetails, "", authDetails.getAuthorities());
        //두번째 인증객체 ( 인증객체, "", 어떤 권한인지)
        //credentials에는 대체적으로 암호화된 정보를 넣는다 / 여기에서는 사용자의 패스워드를 말한다.
    }

    public String getEmail(String token) {
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }

    public boolean isRefreshToken(String token) { //토큰을 받아서 refresh인지 아닌지만 확인해줌
        try {
            return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("type").equals("refresh_token");
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }

}
