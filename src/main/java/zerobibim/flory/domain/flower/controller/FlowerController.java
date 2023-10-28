package zerobibim.flory.domain.flower.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zerobibim.flory.domain.flower.dto.request.FlowerCreateReqeust;
import zerobibim.flory.domain.flower.dto.request.FlowerUpdateRequest;
import zerobibim.flory.domain.flower.dto.response.FlowerDetailResponse;
import zerobibim.flory.domain.flower.dto.response.FlowerIdResponse;
import zerobibim.flory.domain.flower.service.FlowerService;
import zerobibim.flory.global.common.ApiPayload.ApiResponse;

import java.util.List;

@Tag(name = "Flower API", description = "꽃 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/flowers")
public class FlowerController {
    private final FlowerService flowerService;

    /**
     * 새로운 꽃을 생성합니다.
     * @param reqeust 새로운 꽃을 생성하기 위한 DTO입니다.
     * @return 생성된 꽃의 id가 반환됩니다.
     */
    @PostMapping
    public ApiResponse<FlowerIdResponse> createFlower(@RequestBody FlowerCreateReqeust reqeust) {
        return ApiResponse.onSuccess(flowerService.createFlower(reqeust));
    }

    /**
     * 꽃 정보를 업데이트합니다.
     * @param request 업데이트할 꽃 정보에 대한 DTO입니다.
     * @return 업데이트된 꽃의 id가 반환됩니다.
     */
    @PostMapping("/update")
    public ApiResponse<FlowerIdResponse> updateFlower(@RequestBody FlowerUpdateRequest request) {
        return ApiResponse.onSuccess(flowerService.updateFlower(request));
    }

    /**
     * 꽃 전체 정보를 조회합니다.
     * @return 꽃 전체 정보를 리스트로 반환합니다.
     */
    @GetMapping
    public ApiResponse<List<FlowerDetailResponse>> findAllFlower() {
        return ApiResponse.onSuccess(flowerService.findAllFlower());
    }

    /**
     * 꽃 상세 정보를 조회합니다.
     * @return 해당 꽃 상세 정보를 반환합니다.
     */
    @GetMapping("/detail")
    public ApiResponse<FlowerDetailResponse> findFlowerDetail(@RequestParam Long flowerId) {
        return ApiResponse.onSuccess(flowerService.findFlowerDetail(flowerId));
    }
}
