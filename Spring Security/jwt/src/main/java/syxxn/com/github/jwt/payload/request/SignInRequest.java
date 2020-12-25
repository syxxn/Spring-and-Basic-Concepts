package syxxn.com.github.jwt.payload.request;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Builder
public class SignInRequest {

    @Email
    @NotBlank
    String email;

    @NotBlank
    String name;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z1-9]{6,13}",message = "비밀번호는 영어와 숫자를 포함하여 6~13자리 이내로 입력하시오.")
    String password;



}
