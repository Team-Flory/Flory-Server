package zerobibim.flory.domain.Image.repository;

import zerobibim.flory.domain.Image.entity.Image;

import java.util.Optional;

public interface ImageRepository {

    Image save(Image image);

    Optional<Image> findImageById(Long id);
}
