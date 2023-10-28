package zerobibim.flory.domain.member.repository;

import zerobibim.flory.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findMemberById(Long id);
    Optional<Member> findMemberByEmail(String email);
    Optional<Member> findMemberByNickname(String nickname);
}
