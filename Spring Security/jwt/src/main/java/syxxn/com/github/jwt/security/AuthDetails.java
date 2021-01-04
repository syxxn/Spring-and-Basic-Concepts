package syxxn.com.github.jwt.security;

import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import syxxn.com.github.jwt.entity.user.User;

import java.util.ArrayList;
import java.util.Collection;

@AllArgsConstructor
public class AuthDetails implements UserDetails {
    //첫번째 인증객체/ 유저 정보를 인증객체 형태로 가지고 있음

    private final User user; //생성자가 인자값으로 이것만 받음

    //유저가 가지고 있는 권한
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();//빈 리스트를 전달
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail(); // 회원의 아이디 값을 전달!
    }

    //다 true로 해야 인증이 된다고 함
   @Override
    public boolean isAccountNonExpired() { //계정이 만료되지 않았습니다
        return true;
    }

    @Override
    public boolean isAccountNonLocked() { //계정이 잠기지 않았습니다
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() { //자격 증명이 만료되지 않았습니다
        return true;
    }

    @Override
    public boolean isEnabled() { //활성화되었습니다.
        return true;
    }

}
