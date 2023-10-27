package zerobibim.flory.domain.purchase.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Where;
import zerobibim.flory.domain.flower.entity.Flower;
import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.global.common.BaseTime;

import java.time.LocalDate;

@Entity
@Getter
@Where(clause = "deleted_at is null")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Purchase extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member sender;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member receiver;

    @Column(nullable = false)
    private String receiverName;

    @Column(nullable = false)
    private String receiverAddress;

    private LocalDate receiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Flower flower;

    private Long flowerCnt;

    private Long deliveryTip;

    private String nftWord;

}
