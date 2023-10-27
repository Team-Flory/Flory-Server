package zerobibim.flory.global.common.ApiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReasonDTO {
    private boolean isSuccess;
    private String message;
    private String code;
    private HttpStatus httpStatus;
}
