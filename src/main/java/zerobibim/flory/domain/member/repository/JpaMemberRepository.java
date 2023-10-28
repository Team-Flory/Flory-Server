package zerobibim.flory.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobibim.flory.domain.member.entity.Member;

public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
}
