package zerobibim.flory.domain.member.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MemberSignUpRequest {
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
    private String nickname;
    private String walletAddress;
}
