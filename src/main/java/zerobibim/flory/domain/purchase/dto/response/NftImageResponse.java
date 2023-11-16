package zerobibim.flory.domain.purchase.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NftImageResponse {
    private String url;
    private String senderNickname;
    private LocalDate receiveDate;
}
