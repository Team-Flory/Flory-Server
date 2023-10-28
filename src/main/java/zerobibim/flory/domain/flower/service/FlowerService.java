package zerobibim.flory.domain.flower.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zerobibim.flory.domain.flower.dto.request.FlowerCreateReqeust;
import zerobibim.flory.domain.flower.dto.request.FlowerUpdateRequest;
import zerobibim.flory.domain.flower.dto.response.FlowerDetailResponse;
import zerobibim.flory.domain.flower.dto.response.FlowerIdResponse;
import zerobibim.flory.domain.flower.entity.Flower;
import zerobibim.flory.domain.flower.mapper.FlowerMapper;
import zerobibim.flory.domain.flower.repository.FlowerRepository;
import zerobibim.flory.global.common.ApiPayload.code.status.ErrorStatus;
import zerobibim.flory.global.common.EntityLoader;
import zerobibim.flory.global.common.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FlowerService implements EntityLoader<Flower, Long> {
    private final FlowerRepository flowerRepository;
    private final FlowerMapper flowerMapper;

    public FlowerIdResponse createFlower(FlowerCreateReqeust reqeust) {
        // 중복 꽃 여부 확인
        if(flowerRepository.existsFlowerByName(reqeust.getName()))
            throw new ExceptionHandler(ErrorStatus.FLOWER_EXISTED);

        Flower newflower = flowerRepository.save(
                flowerMapper.toEntity(reqeust.getName()
                        , reqeust.getDescription()
                        , reqeust.getPrice()));

        return new FlowerIdResponse(newflower.getId());
    }

    @Transactional
    public FlowerIdResponse updateFlower(FlowerUpdateRequest request) {
        // 꽃 존재 여부 확인
        Flower flower = loadEntity(request.getFlowerId());

        flower.update(request.getDescription(), request.getPrice());
        return new FlowerIdResponse(flower.getId());
    }

    public List<FlowerDetailResponse> findAllFlower() {
        return flowerRepository.findAll().stream().map(flowerMapper::toResponse).toList();
    }

    public FlowerDetailResponse findFlowerDetail(Long flowerId) {
        return flowerMapper.toResponse(loadEntity(flowerId));
    }

    @Override
    public Flower loadEntity(Long id) {
        Optional<Flower> flower = flowerRepository.findFlowerById(id);
        if(flower.isEmpty()) throw new ExceptionHandler(ErrorStatus.FLOWER_NOT_FOUND);
        return flower.get();
    }
}
