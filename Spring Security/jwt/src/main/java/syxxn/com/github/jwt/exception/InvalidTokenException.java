package syxxn.com.github.jwt.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED, reason = "Invalid Token Exception")
public class InvalidTokenException extends RuntimeException{
}
