package zerobibim.flory.domain.purchase.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zerobibim.flory.domain.purchase.dto.response.NftImageResponse;
import zerobibim.flory.domain.purchase.dto.request.PurchaseCreateRequest;
import zerobibim.flory.domain.purchase.dto.response.PurchaseIdResponse;
import zerobibim.flory.domain.purchase.service.PurchaseService;
import zerobibim.flory.global.common.ApiPayload.ApiResponse;

import java.util.List;

@Tag(name = "Purchase API" , description = "구매 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    /**
     * 새로운 구매 정보를 생성합니다.
     * @param request 새로운 구매 정보 생성을 위한 DTO입니다.
     * @return 생성된 구매 정보의 id가 반환된니다.
     */
    @PostMapping
    @Operation(summary = "구매하기 API")
    public ApiResponse<PurchaseIdResponse> createPurchase(@RequestBody PurchaseCreateRequest request) {
        return ApiResponse.onSuccess(purchaseService.createPurchase(request));
    }

    @GetMapping("/nft")
    @Operation(summary = "받은 nft 이미지 조회 API")
    public ApiResponse<List<NftImageResponse>> getNftImages(@RequestParam Long memberId) {
        return ApiResponse.onSuccess(purchaseService.getNftImages(memberId));
    }
}
