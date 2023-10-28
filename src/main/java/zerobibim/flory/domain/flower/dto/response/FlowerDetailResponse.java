package zerobibim.flory.domain.flower.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlowerDetailResponse {
    private Long flowerId;
    private String name;
    private String description;
    private Long price;
}
