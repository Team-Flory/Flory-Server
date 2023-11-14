package zerobibim.flory.domain.purchase.mapper;

import org.springframework.stereotype.Component;
import zerobibim.flory.domain.flower.entity.Flower;
import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.domain.purchase.entity.Purchase;

import java.time.LocalDate;

@Component
public class PurchaseMapper {
    public Purchase toEntity(Member sender, Member receiver, LocalDate receiveDate,
                             Flower flower, String receiverName, String receiverAddress,
                             int flowerCnt, int deliveryTip, int totalPrice) {
        return Purchase.builder()
                .sender(sender)
                .receiver(receiver)
                .receiveDate(receiveDate)
                .flower(flower)
                .receiverName(receiverName)
                .receiverAddress(receiverAddress)
                .flowerCnt(flowerCnt)
                .deliveryTip(deliveryTip)
                .totalPrice(totalPrice)
                .build();

    }
}
