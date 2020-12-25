package syxxn.com.github.jwt.entity.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
@Builder
@Getter
@NoArgsConstructor
public class User {

    @Id
    @Email
    String email;

    @Column(nullable = false, length = 30)
    String name;

    @Column(nullable = false)
    String password;

}
