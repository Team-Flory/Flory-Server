package zerobibim.flory.domain.test.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import zerobibim.flory.domain.test.dto.TestRequest;
import zerobibim.flory.domain.test.dto.TestResponse;

@Tag(name = "예제 API", description = "Swagger 테스트용 API")
@RestController
@RequestMapping("/test")
public class SwaggerTestController {
    @PostMapping
    public void postTestController(@RequestBody TestRequest request) { }

    @GetMapping
    public TestResponse getTestController() {
        return new TestResponse("테스트 제목", "테스트 내용");
    }
}
