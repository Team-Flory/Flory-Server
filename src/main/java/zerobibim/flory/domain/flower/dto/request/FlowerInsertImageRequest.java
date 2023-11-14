package zerobibim.flory.domain.flower.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class FlowerInsertImageRequest {
    private Long flowerId;
    private Long imageId;
}
