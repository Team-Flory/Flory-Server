package zerobibim.flory.domain.purchase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobibim.flory.domain.flower.entity.Flower;
import zerobibim.flory.domain.flower.service.FlowerService;
import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.domain.member.service.MemberService;
import zerobibim.flory.domain.purchase.dto.request.PurchaseCreateRequest;
import zerobibim.flory.domain.purchase.dto.response.PurchaseIdResponse;
import zerobibim.flory.domain.purchase.entity.Purchase;
import zerobibim.flory.domain.purchase.mapper.PurchaseMapper;
import zerobibim.flory.domain.purchase.repository.PurchaseRepository;
import zerobibim.flory.global.common.ApiPayload.code.status.ErrorStatus;
import zerobibim.flory.global.common.EntityLoader;
import zerobibim.flory.global.common.ExceptionHandler;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PurchaseService implements EntityLoader<Purchase, Long> {
    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper purchaseMapper;
    private final MemberService memberService;
    private final FlowerService flowerService;

    public PurchaseIdResponse createPurchase(PurchaseCreateRequest request) {
        // TODO Validation 추가

        Member receiver = memberService.findReceiver(request.getReceiverNickname());
        Flower flower = flowerService.loadEntity(request.getFlowerId());

        Purchase newPurchase = purchaseRepository.save(
                purchaseMapper.toEntity(
                        null, receiver, request.getReceiveDate(), flower, request.getReceiverName(), request.getReceiverAddress(),
                        request.getFlowerQuentity(), request.getNftComment(), request.getDeliveryTip(), request.getTotalPrice()
                ));

        return new PurchaseIdResponse(newPurchase.getId());
    }

    @Override
    public Purchase loadEntity(Long purchaseId) {
        Optional<Purchase> purchase = purchaseRepository.findPurchaseById(purchaseId);
        if(purchase.isEmpty()) throw new ExceptionHandler(ErrorStatus.PURCHASE_NOT_FOUND);
        return purchase.get();
    }
}
