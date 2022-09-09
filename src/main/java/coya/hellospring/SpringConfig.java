package coya.hellospring;

import coya.hellospring.repository.MemberRepository;
import coya.hellospring.repository.MemoryMemberRepository;
import coya.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    // spring이 올라올때
    // 멤버서비스를 스프링 빈에 올리고
    // 멤버리포지토리도 스프링 빈에다가 올려줌
    // 스프링 빈 등록을 자바코드로 직접 등록 완료.
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        //현재 이 연습 프로젝트는 초기에 DB가 정해지지 않은 상태에서
        //인터페이스 구현체로 임시 운용하다가 DB를 이후에 정해지는 시나리오로 진행중

        return new MemoryMemberRepository();
    }
}
