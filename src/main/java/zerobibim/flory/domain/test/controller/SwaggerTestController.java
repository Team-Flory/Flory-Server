package zerobibim.flory.domain.test.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import zerobibim.flory.domain.test.dto.TestRequest;
import zerobibim.flory.domain.test.dto.TestResponse;
import zerobibim.flory.domain.test.mapper.TestMapper;
import zerobibim.flory.domain.test.service.TestService;
import zerobibim.flory.global.common.ApiPayload.ApiResponse;

@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class SwaggerTestController {

    private final TestService testService;
    @PostMapping
    public void postTestController(@RequestBody TestRequest request) { }

    @GetMapping
    public ApiResponse<TestResponse.TestDTO> testAPI() {
        return ApiResponse.onSuccess(TestMapper.toTestResponse());
    }

    @GetMapping("/exception")
    public ApiResponse<TestResponse.TestExceptionDTO> exceptionAPI(@RequestParam Integer flag) {
        testService.CheckFlag(flag);
        return ApiResponse.onSuccess(TestMapper.toTestExceptionResponse(flag));
    }
}
