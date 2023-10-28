package zerobibim.flory.domain.flower.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FlowerCreateReqeust {
    private String name;
    private String description;
    private Long price;
}
