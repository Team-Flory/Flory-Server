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

    private String receiverName;
    private String receiverAddress;

    private LocalDate receiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Flower flower;

    private int flowerCnt;

    private int deliveryTip;

    private int totalPrice;

    private Boolean isDelivered;

    @Builder
    public Purchase(Member sender, Member receiver, LocalDate receiveDate,
                    Flower flower, String receiverName, String receiverAddress,
                    int flowerCnt, int deliveryTip, int totalPrice) {
        this.sender = sender;
        this.receiver = receiver;
        this.receiveDate = receiveDate;
        this.receiverName = receiverName;
        this.receiverAddress = receiverAddress;
        this.flower = flower;
        this.flowerCnt = flowerCnt;
        this.deliveryTip = deliveryTip;
        this.totalPrice = totalPrice;
        this.isDelivered = Boolean.FALSE;

    }
}
