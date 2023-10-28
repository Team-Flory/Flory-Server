package zerobibim.flory.domain.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignUpRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String walletAddress;
    private String walletPassword;
}
