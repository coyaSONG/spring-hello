package coya.hellospring.controller;

import coya.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//spring의 정형화된 형태
//1. Controller : 컨트롤러를 통해서 외부 요청을 받고
//2. Service : 서비스에서 비즈니스로직을 만들고
//3. Repository : 리포지토리에서 데이터를 저장

// 스프링이 올라올때 스프링 컨테이너라는 박스가 생성되고
// 그 박스 안에 컨트롤러들이 스프링빈으로 관리됨
@Controller
public class MemberController {
    // new 생성자로 새로 생성하여 쓸 필요 X
    // -> 멤버서비스같은 정보를 가진 서비스는 컨테이너 상 한번만 생성해서 다같이 써도 무관하기 때문
    private MemberService memberService;



    //Autowired를 써주면 스프링이 컨테이너 생성할때 생성된 서비스를 자동으로 연결해줌
    // Dependency injection 3가지
    // 1. 생성자 주입 : 생성자를 통해서 멤버서비스가 멤버 컨트롤러에 주입이 됨. 추천
    // 주입 방식중 생성자 주입을 쓰는 이유 참조 => (https://madplay.github.io/post/why-constructor-injection-is-better-than-field-injection)
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 2. 필드 주입 : 스프링 뜰때 외엔 중간에 바꿀수있는 방법이 없어서 별로 안씀.
    //    @Autowired private MemberService memberService;


    // 3. setter 주입 : 퍼블릭으로 노출이 되어버림.
    //    @Autowired
    //    public void setMemberService(MemberService memberService) {
    //        this.memberService = memberService;
    //    }


}
