package zerobibim.flory.domain.Image.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobibim.flory.domain.Image.entity.Image;

public interface JpaImageRepository extends JpaRepository<Image, Long>, ImageRepository {
}
