package Spring_KYH_Intro.Spring_KYH_Intro.service;

import Spring_KYH_Intro.Spring_KYH_Intro.domain.Member;
import Spring_KYH_Intro.Spring_KYH_Intro.repository.MemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /*
        회원가입
    */
    public Long join(Member member) {

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }
    
    /*
       회원전체조회
    */   
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /*
        회원조회
    */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 같은 이름이 있는 중복 회원X
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
