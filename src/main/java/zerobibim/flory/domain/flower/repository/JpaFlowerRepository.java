package zerobibim.flory.domain.flower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobibim.flory.domain.flower.entity.Flower;

public interface JpaFlowerRepository extends JpaRepository<Flower, Long>, FlowerRepository {
}
