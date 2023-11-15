package zerobibim.flory.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobibim.flory.domain.member.dto.request.MemberSignInRequest;
import zerobibim.flory.domain.member.dto.request.MemberSignUpRequest;
import zerobibim.flory.domain.member.dto.response.MemberIdResponse;
import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.domain.member.mapper.MemberMapper;
import zerobibim.flory.domain.member.repository.MemberRepository;
import zerobibim.flory.global.common.ApiPayload.code.status.ErrorStatus;
import zerobibim.flory.global.common.EntityLoader;
import zerobibim.flory.global.common.ExceptionHandler;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements EntityLoader<Member, Long> {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberIdResponse createMember(MemberSignUpRequest request) {
        // 닉네임 공백 여부 체크
        if(request.getNickname().isBlank()) throw new ExceptionHandler(ErrorStatus.NICKNAME_BLANK);

        // 닉네임 중복 여부 체크
        Optional<Member> member = memberRepository.findMemberByNickname(request.getNickname());
        if(member.isPresent()) throw new ExceptionHandler(ErrorStatus.NICKNAME_DUPLICATED);

        // TODO 비밀번호 암호화

        Member newMember =  memberRepository.save(
                memberMapper.toEntity(
                        request.getName(), request.getEmail(), request.getPassword(), request.getPhoneNumber(),
                        request.getNickname(), request.getWalletAddress()));

        return new MemberIdResponse(newMember.getId());
    }

    public MemberIdResponse checkMember(MemberSignInRequest request) {
        Optional<Member> member = memberRepository.findMemberByEmail(request.getEmail());
        // 해당 이메일 멤버 존재 여부 확인
        if(member.isEmpty()) throw new ExceptionHandler(ErrorStatus.MEMBER_NOT_FOUND);

        // 비밀번호 일치 여부 확인
        if(!request.getPassword().equals(member.get().getPassword())) throw new ExceptionHandler(ErrorStatus.PASSWORD_NOT_MATCH);

        return new MemberIdResponse(member.get().getId());
    }

    public Member findMemberByNickname(String nickname) {
        Optional<Member> member = memberRepository.findMemberByNickname(nickname);
        // 해당 닉네임 존재하지 않을 경우
        if(member.isEmpty()) throw new ExceptionHandler(ErrorStatus.RECEIVER_NOT_FOUND);

        return member.get();
    }

    @Override
    public Member loadEntity(Long memberId) {
        Optional<Member> member = memberRepository.findMemberById(memberId);
        if(member.isEmpty()) throw new ExceptionHandler(ErrorStatus.MEMBER_NOT_FOUND);
        return member.get();
    }
}
