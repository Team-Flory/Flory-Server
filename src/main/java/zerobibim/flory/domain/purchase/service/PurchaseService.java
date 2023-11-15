package zerobibim.flory.domain.purchase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import zerobibim.flory.domain.Image.service.ImageService;
import zerobibim.flory.domain.contract.dto.NFTRequestDto;
import zerobibim.flory.domain.contract.service.Web3jService;
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
    private final ImageService imageService;
    private final Web3jService web3jService;

    public PurchaseIdResponse createPurchase(PurchaseCreateRequest request) {
        Member sender = memberService.loadEntity(request.getMemberId());
        Member receiver = memberService.findMemberByNickname(request.getReceiverNickname());
        Flower flower = flowerService.loadEntity(request.getFlowerId());
        if(flower.getImage() == null) throw new ExceptionHandler(ErrorStatus.NO_IMAGE_IN_FLOWER);

        imageService.makeNft(flower.getImage().getId(), sender.getId(), receiver.getId());

        Purchase newPurchase = purchaseRepository.save(
                purchaseMapper.toEntity(
                        sender, receiver, request.getReceiveDate(), flower
                ));

        NFTRequestDto.MemberNFTInfo nftInfo = new NFTRequestDto.MemberNFTInfo(receiver.getWalletAddress(), "ipfs://QmZUS5QQK4nSKLFWui54vVp4CJTEBaqfcfBJCry7vjRVCc");
        try {
            TransactionReceipt transactionReceipt = web3jService.nftCreate(nftInfo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new PurchaseIdResponse(newPurchase.getId());
    }

    @Override
    public Purchase loadEntity(Long purchaseId) {
        Optional<Purchase> purchase = purchaseRepository.findPurchaseById(purchaseId);
        if(purchase.isEmpty()) throw new ExceptionHandler(ErrorStatus.PURCHASE_NOT_FOUND);
        return purchase.get();
    }
}
