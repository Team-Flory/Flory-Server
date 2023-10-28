package zerobibim.flory.domain.purchase.repository;

import zerobibim.flory.domain.purchase.entity.Purchase;

import java.util.Optional;

public interface PurchaseRepository {

    Purchase save(Purchase purchase);
    Optional<Purchase> findPurchaseById(Long id);
}
