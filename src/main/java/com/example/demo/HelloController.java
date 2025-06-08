package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/") // 루트 경로 (http://localhost:8080/) 에 대한 요청을 처리
    @ResponseBody    // 이 메서드의 반환값을 HTTP 응답 본문에 직접 쓰라는 의미
    public String home() {
        return "Hello, Spring Boot!";
    }

    @GetMapping("/hello") // http://localhost:8080/hello 에 대한 요청을 처리
    @ResponseBody
    public String hello() {
        return "Welcome to my Spring Boot App!";
    }
}