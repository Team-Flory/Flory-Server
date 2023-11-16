package zerobibim.flory.domain.purchase.repository;

import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.domain.purchase.entity.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    Purchase save(Purchase purchase);
    Optional<Purchase> findPurchaseById(Long id);
    List<Purchase> findAllByReceiverAndAndIsNftTrue(Member receiver);

}
