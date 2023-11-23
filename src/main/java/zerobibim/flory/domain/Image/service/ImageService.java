package zerobibim.flory.domain.Image.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import zerobibim.flory.domain.Image.dto.response.ImageIdResponse;
import zerobibim.flory.domain.Image.entity.Image;
import zerobibim.flory.domain.Image.mapper.ImageMapper;
import zerobibim.flory.domain.Image.repository.ImageRepository;
import zerobibim.flory.global.common.ApiPayload.code.status.ErrorStatus;
import zerobibim.flory.global.common.EntityLoader;
import zerobibim.flory.global.common.ExceptionHandler;
import zerobibim.flory.utils.S3ImageComponent;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ImageService implements EntityLoader<Image, Long> {

    private final ImageMapper imageMapper;
    private final ImageRepository imageRepository;
    private final S3ImageComponent s3ImageComponent;

    @Transactional
    public ImageIdResponse createImage(final MultipartFile flowerImage) {
        String imageUrl = uploadImage(flowerImage);

        Image newImage = imageRepository.save(
                imageMapper.toEntity(imageUrl));
        return new ImageIdResponse(newImage.getId());
    }

    private String uploadImage(final MultipartFile flowerImage) {
        if(flowerImage.isEmpty()) {
            throw new ExceptionHandler(ErrorStatus.IMAGE_BLANK);
        }
        return s3ImageComponent.uploadImage("flower-image", flowerImage);
    }

    @Override
    public Image loadEntity(Long id) {
        Optional<Image> image = imageRepository.findImageById(id);
        if(image.isEmpty()) throw new ExceptionHandler(ErrorStatus.IMAGE_NOT_FOUND);
        return image.get();
    }
}
