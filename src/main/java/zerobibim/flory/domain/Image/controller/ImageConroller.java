package zerobibim.flory.domain.Image.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import zerobibim.flory.domain.Image.dto.response.ImageIdResponse;
import zerobibim.flory.domain.Image.service.ImageService;
import zerobibim.flory.global.common.ApiPayload.ApiResponse;

@Tag(name = "Image API", description = "이미지 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/image")
public class ImageConroller {
    private final ImageService imageService;

    @PostMapping
    @Operation(summary = "이미지 생성 API")
    public ApiResponse<ImageIdResponse> createImage(@RequestPart("flower_image") MultipartFile flowerImage) {
        return ApiResponse.onSuccess(imageService.createImage(flowerImage));
    }
}
