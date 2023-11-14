package zerobibim.flory.domain.purchase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PurchaseCreateRequest {
    private Long memberId;
    private String receiverName;
    private String receiverAddress;
    private String receiverNickname;
    private Long flowerId;
    private int flowerQuentity;
    private LocalDate receiveDate;
    private int deliveryTip;
    private int totalPrice;
}
