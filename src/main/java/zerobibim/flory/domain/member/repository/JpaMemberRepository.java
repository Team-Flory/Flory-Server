package zerobibim.flory.domain.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import zerobibim.flory.domain.member.entity.Member;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
}
