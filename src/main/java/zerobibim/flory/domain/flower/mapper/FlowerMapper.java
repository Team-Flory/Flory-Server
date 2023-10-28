package zerobibim.flory.domain.flower.mapper;

import org.springframework.stereotype.Component;
import zerobibim.flory.domain.flower.dto.response.FlowerDetailResponse;
import zerobibim.flory.domain.flower.entity.Flower;

@Component
public class FlowerMapper {
    public Flower toEntity(String name, String description, Long price) {
        return Flower.builder()
                .name(name)
                .description(description)
                .price(price)
                .build();
    }

    public FlowerDetailResponse toResponse(Flower flower) {
        return new FlowerDetailResponse(flower.getId(), flower.getName(), flower.getDescription(), flower.getPrice());
    }
}
