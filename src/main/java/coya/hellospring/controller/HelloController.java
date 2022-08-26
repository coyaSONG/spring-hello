package coya.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("greeting")
    public String hello(Model model) {
        //key는 data, value는 hello!
        model.addAttribute("data","hello!!");
        //리턴에 넣어진 이름의 템플릿 폴더의 view에 렌더링시킴
        //컨트롤러에서 리턴값의 문자 => 스프링부트의 viewResolver가 해당 화면을 찾아서 처리.
        //기본 셋팅 resources:templates/ { return 값 }.html
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
