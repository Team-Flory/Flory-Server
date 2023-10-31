package zerobibim.flory.domain.member.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import zerobibim.flory.global.common.BaseTime;

@Entity
@Getter
@Where(clause = "deleted_at is null")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String phoneNumber;
    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String walletAddress;
    @Column(nullable = false)
    private String walletPassword;


    @Builder
    public Member(String name, String email, String password, String phoneNumber,
                  String nickname, String walletAddress, String walletPassword) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.nickname = nickname;
        this.walletAddress = walletAddress;
        this.walletPassword = walletPassword;
    }
}

