package zerobibim.flory.domain.Image.mapper;

import org.springframework.stereotype.Component;
import zerobibim.flory.domain.Image.entity.Image;

@Component
public class ImageMapper {
    public Image toEntity(String url) {
        return Image.builder()
                .url(url)
                .build();
    }
}
