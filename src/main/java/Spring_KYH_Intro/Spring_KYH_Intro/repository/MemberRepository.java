package Spring_KYH_Intro.Spring_KYH_Intro.repository;

import Spring_KYH_Intro.Spring_KYH_Intro.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}