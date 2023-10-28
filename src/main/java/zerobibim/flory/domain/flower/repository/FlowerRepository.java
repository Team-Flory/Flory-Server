package zerobibim.flory.domain.flower.repository;

import zerobibim.flory.domain.flower.entity.Flower;

import java.util.List;
import java.util.Optional;

public interface FlowerRepository {

    Flower save(Flower flower);
    Optional<Flower> findFlowerById(Long id);

    Boolean existsFlowerByName(String name);

    List<Flower> findAll();
}
