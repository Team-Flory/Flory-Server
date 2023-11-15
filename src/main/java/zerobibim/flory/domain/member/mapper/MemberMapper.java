package zerobibim.flory.domain.member.mapper;

import org.springframework.stereotype.Component;
import zerobibim.flory.domain.member.entity.Member;

@Component
public class MemberMapper {
    public Member toEntity(String name, String email, String password, String phoneNumber,
                           String nickname, String walletAddress) {
        return Member.builder()
                .name(name)
                .email(email)
                .password(password)
                .phoneNumber(phoneNumber)
                .nickname(nickname)
                .walletAddress(walletAddress)
                .build();
    }
}
