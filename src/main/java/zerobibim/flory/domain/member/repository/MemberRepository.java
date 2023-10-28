package zerobibim.flory.domain.member.repository;

import zerobibim.flory.domain.member.entity.Member;

import java.util.Optional;

public interface MemberRepository {

    Optional<Member> findMemberById(Long id);
    Member save(Member member);
}
