package zerobibim.flory.domain.purchase.mapper;

import org.springframework.stereotype.Component;
import zerobibim.flory.domain.flower.entity.Flower;
import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.domain.purchase.entity.Purchase;

import java.time.LocalDate;

@Component
public class PurchaseMapper {
    public Purchase toEntity(Member sender, Member receiver, LocalDate receiveDate, Flower flower) {
        return Purchase.builder()
                .sender(sender)
                .receiver(receiver)
                .receiveDate(receiveDate)
                .flower(flower)
                .build();

    }
}
