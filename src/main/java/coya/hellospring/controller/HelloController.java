package coya.hellospring.controller;

import com.fasterxml.jackson.databind.deser.ValueInstantiator;
import coya.hellospring.HelloSpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //ResponseBody라는 어노테이션이 붙어있을시
    //리턴이 문자열 : StringHttpMessageConverter -> 문자열을 그냥 그대로 반환
    //리턴이 객체 :  MappingJackson2HttpMessageConverter -> JSON형식으로 변환 후 반환

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        //name은 private 이라 외부에서 꺼내 쓸수가 없기에 게터 세터 메소드로 접근
        private String name;
        // 자바빈 규약
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
