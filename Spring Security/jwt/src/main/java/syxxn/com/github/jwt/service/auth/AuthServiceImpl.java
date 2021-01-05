package syxxn.com.github.jwt.service.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import syxxn.com.github.jwt.entity.refreshtoken.RefreshToken;
import syxxn.com.github.jwt.entity.refreshtoken.RefreshTokenRepository;
import syxxn.com.github.jwt.entity.user.User;
import syxxn.com.github.jwt.entity.user.UserRepository;
import syxxn.com.github.jwt.exception.InvalidTokenException;
import syxxn.com.github.jwt.exception.UserNotFoundException;
import syxxn.com.github.jwt.payload.request.SignInRequest;
import syxxn.com.github.jwt.payload.response.AccessTokenResponse;
import syxxn.com.github.jwt.payload.response.TokenResponse;
import syxxn.com.github.jwt.security.JwtTokenProvider;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Value("${auth.jwt.exp.refresh}")
    private Long refreshExp;

    @Override
    public TokenResponse signIn(SignInRequest signInRequest) { //map의 순서는 변경할 수 없음
        return userRepository.findById(signInRequest.getEmail())//request에서 받은 email값으로 user를 찾고
                .filter(user -> passwordEncoder.matches(signInRequest.getPassword(), user.getPassword())) //그 유저의 비밀번호와 요청받은 비밀번호를 비교해본다
                    .map(User::getEmail) //user1-> user1.getEmail()을 압축해서 쓴 것 / user의 이메일을 다음 map으로 넘겨주기 위해 사용함
                    .map(email->{
                        String refreshToken = jwtTokenProvider.generateRefreshToken(email);
                        return new RefreshToken(email, refreshToken, refreshExp);
                    })
                    .map(refreshTokenRepository::save)
                    .map(refreshToken -> {
                        String accessToken = jwtTokenProvider.generateAccessToken(refreshToken.getEmail());
                        return new TokenResponse(accessToken, refreshToken.getRefreshToken(), refreshToken.getRefreshExp());
                    })
                .orElseThrow(UserNotFoundException::new);

    }

    @Override
    public AccessTokenResponse tokenRefresh(String recievedToken) {// 본래 가지고 있던 refreshToken을 가지고 들어옴
        if(!jwtTokenProvider.isRefreshToken(recievedToken)) { //만약 가지고 온 토큰이 refreshToken이 아니라면
            throw new InvalidTokenException();//잘못된 토큰이라고 오류 띄워주기
        }

        return refreshTokenRepository.findByRefreshToken(recievedToken) //매개변수로 받은 토큰을 이용하여 토큰의 정보를 찾고
                .map(refreshToken -> //refreshToken을 사용하여 accessToken을 재발급 받는다.
                        new AccessTokenResponse(jwtTokenProvider.generateAccessToken(refreshToken.getEmail())))
                .orElseThrow(UserNotFoundException::new);
    }


}
