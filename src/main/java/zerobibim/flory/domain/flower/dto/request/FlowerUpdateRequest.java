package zerobibim.flory.domain.flower.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlowerUpdateRequest {
    private Long flowerId;
    private String description;
    private Long price;
}
