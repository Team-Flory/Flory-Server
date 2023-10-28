package zerobibim.flory.domain.member.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zerobibim.flory.domain.member.dto.request.MemberSignInRequest;
import zerobibim.flory.domain.member.dto.request.MemberSignUpRequest;
import zerobibim.flory.domain.member.dto.response.MemberIdResponse;
import zerobibim.flory.domain.member.service.MemberService;
import zerobibim.flory.global.common.ApiPayload.ApiResponse;

@Tag(name = " Member API", description = "멤버 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;

    /**
     * 회원가입 : 새로운 멤버를 생성합니다.
     * @param request 새로운 멤버를 생성하기 위한 DTO입니다.
     * @return 생성된 멤버의 id가 반환됩니다.
     */
    @PostMapping
    public ApiResponse<MemberIdResponse> singUpMember(@RequestBody MemberSignUpRequest request) {
        return ApiResponse.onSuccess(memberService.createMember(request));
    }

    /**
     * 로그인 : 가입이 된 상태라면 로그인 수행
     * @param request 로그인을 하기 위한 DTO입니다.
     * @return 기존의 멤버의 id가 반환됩니다.
     */
    @PostMapping("/login")
    public ApiResponse<MemberIdResponse> signInMember(@RequestBody MemberSignInRequest request) {
        return ApiResponse.onSuccess(memberService.checkMember(request));
    }
}
