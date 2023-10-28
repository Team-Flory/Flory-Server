package zerobibim.flory.domain.member.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobibim.flory.domain.member.dto.request.MemberSignUpRequest;
import zerobibim.flory.domain.member.dto.response.MemberIdResponse;
import zerobibim.flory.domain.member.entity.Member;
import zerobibim.flory.domain.member.mapper.MemberMapper;
import zerobibim.flory.domain.member.repository.MemberRepository;
import zerobibim.flory.domain.test.exception.TestHandler;
import zerobibim.flory.global.common.ApiPayload.code.status.ErrorStatus;
import zerobibim.flory.global.common.EntityLoader;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService implements EntityLoader<Member, Long> {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public MemberIdResponse createMember(MemberSignUpRequest request) {
        // TODO Validation 추가하기

        // TODO 비밀번호 암호화

        Member newMember =  memberRepository.save(
                memberMapper.toEntity(
                        request.getName(), request.getEmail(), request.getPassword(),
                        request.getPhoneNumber(), request.getWalletAddress(), request.getWalletPassword()));

        return new MemberIdResponse(newMember.getId());
    }


    @Override
    public Member loadEntity(Long id) {
        Optional<Member> member = memberRepository.findMemberById(id);
        if(member.isEmpty()) throw new TestHandler(ErrorStatus.MEMBER_NOT_FOUND);
        return member.get();
    }
}
