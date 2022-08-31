package coya.hellospring.service;

import coya.hellospring.domain.Member;
import coya.hellospring.repository.MemberRepository;
import coya.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//@Controller, @Service, @Repository 또는 @Component 같은 어노테이션을 등록해서
//의존관계 설정하는 방법을 컴포넌트 스캔 및 의존관계 설정 이라고 부름.
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    //Autowired를 통해 스프링 컨테이너에 컨트롤러를 불러올때
    //Autowired가 적용된 서비스를 주입해줌
    //DI 의존관계 설정
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /** 회원가입 */
    public Long join(Member member) {
        //ex: 같은 이름을 가진 중복 회원 X
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName((member.getName()))
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    public List<Member> findMember() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
