package zerobibim.flory.domain.flower.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobibim.flory.domain.flower.entity.Flower;

import java.util.List;

public interface JpaFlowerRepository extends JpaRepository<Flower, Long>, FlowerRepository {
}
