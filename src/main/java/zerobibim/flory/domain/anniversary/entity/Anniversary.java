package zerobibim.flory.domain.anniversary.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.global.common.BaseTime;

import java.time.LocalDate;

@Entity
@Getter
@Where(clause = "deleted_at is null")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Anniversary extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;
    private String content;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;

    @Builder
    public Anniversary(String title, String content, LocalDate date) {
        this.title = title;
        this.content = content;
        this.date = date;
    }
}
