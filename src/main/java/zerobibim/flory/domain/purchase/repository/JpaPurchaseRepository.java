package zerobibim.flory.domain.purchase.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobibim.flory.domain.purchase.entity.Purchase;

public interface JpaPurchaseRepository extends JpaRepository<Purchase, Long>, PurchaseRepository {
}
