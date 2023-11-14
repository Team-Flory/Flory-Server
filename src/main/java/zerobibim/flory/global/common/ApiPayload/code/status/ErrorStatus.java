package zerobibim.flory.global.common.ApiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import zerobibim.flory.global.common.ApiPayload.code.BaseErrorCode;
import zerobibim.flory.global.common.ApiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관련 응답
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST, "MEMBER4001", "존재하지 않는 사용자입니다."),
    MEMBER_EXISTED(HttpStatus.BAD_REQUEST, "MEMBER4002", "이미 사용중인 계정입니다."),
    PASSWORD_NOT_MATCH(HttpStatus.BAD_REQUEST, "MEMBER4003","비밀번호가 일치하지 않습니다."),
    NICKNAME_DUPLICATED(HttpStatus.BAD_REQUEST, "MEMBER4004", "이미 사용중인 닉네임입니다."),
    NICKNAME_BLANK(HttpStatus.BAD_REQUEST, "MEMBER4005", "닉네임은 공백일 수 없습니다."),

    // 꽃 관련 응답
    FLOWER_NOT_FOUND(HttpStatus.BAD_REQUEST, "FLOWER4001", "존재하지 않는 꽃입니다."),
    FLOWER_EXISTED(HttpStatus.BAD_REQUEST, "FLOWER4002","이미 존재하는 꽃입니다."),
    // 기념일 관련 응답

    // 구매 관련 응답
    PURCHASE_NOT_FOUND(HttpStatus.BAD_REQUEST, "PURCHASE4001","존재하지 않는 구매 정보입니다."),
    RECEIVER_NOT_FOUND(HttpStatus.BAD_REQUEST, "PURCHASE4002", "존재하지 않는 닉네임입니다."),

    // 테스트 관련 응답
    TEST_EXCEPTION(HttpStatus.BAD_REQUEST, "TEST4001", "테스트를 위한 에러 코드"),

    // 이미지 관련 응답
    IMAGE_BLANK(HttpStatus.BAD_REQUEST, "IMAGE4001", "이미지 파일이 없습니다."),
    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();

    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }

}
