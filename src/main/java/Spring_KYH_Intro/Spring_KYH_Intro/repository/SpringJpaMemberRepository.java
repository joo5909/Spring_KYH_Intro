package Spring_KYH_Intro.Spring_KYH_Intro.repository;

import Spring_KYH_Intro.Spring_KYH_Intro.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    Optional<Member> findByName(String name);


}
