package com.example.demo.controller;

import com.example.demo.entity.member; // Member 엔티티로 변경
import com.example.demo.repository.memberRepository; // MemberRepository로 변경
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/members") // URL도 /users 대신 /members로 변경하는 것이 좋습니다.
public class memberController {

    private final memberRepository memberRepository; // MemberRepository로 변경

    public memberController(memberRepository memberRepository) { // 매개변수도 변경
        this.memberRepository = memberRepository;
    }

    @GetMapping
    public String listmembers(Model model) { // 메서드 이름도 변경
        List<member> members = memberRepository.findAll(); // 모든 Member 데이터를 가져옵니다.
        model.addAttribute("members", members); // "users" 대신 "members"라는 이름으로 모델에 추가합니다.
        return "members"; // "members.html" 템플릿을 렌더링합니다.
    }
}