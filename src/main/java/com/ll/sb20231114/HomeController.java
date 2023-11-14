package com.ll.sb20231114;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 컨트롤러 입니다. 어노테이션 - 주석 아래 클래스가 컨트롤러다라는 것을 알려줌
public class HomeController
{
    @GetMapping("/")
    @ResponseBody // 이 함수의 리턴값을 그대로 브라우저에 전송하라는 의미
    String showMain()
    {
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    String showAbout()
    {
        return "개발자 커뮤니티";
    }
}