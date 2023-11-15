package zerobibim.flory.domain.purchase.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class PurchaseCreateRequest {
    private Long memberId;
    private String receiverNickname;
    private Long flowerId;
    private LocalDate receiveDate;
}
