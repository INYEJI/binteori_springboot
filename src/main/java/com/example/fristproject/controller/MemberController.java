package com.example.fristproject.controller;

import com.example.fristproject.dto.MemberForm;
import com.example.fristproject.entity.Article;
import com.example.fristproject.entity.Member;
import com.example.fristproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository memberRepository;

    @GetMapping("")
    public String index(Model model) {

        List<Member> memberList = (List<Member>)memberRepository.findAll();

        model.addAttribute("memberList", memberList);

        return "/members/index";
    }

    @GetMapping("/new")
    public String newMember(Model model) {
        return "/members/new";
    }

    @PostMapping("/create")
    public String createMember(MemberForm form) {

        log.info("Create member form: {}", form);

        //1. MemberForm -> member entity 변환
        Member member = form.toEntity();

        //2. DB 저장
        Member savedMember = memberRepository.save(member);

        return "redirect:/members";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {

        //1. {id}값을 DB에서 꺼내오기
        Member memberEntity = memberRepository.findById(id).orElse(null);

        log.info("memberEntity : {}", memberEntity);

        //2. Entity -> Dto 변환
        // 생략

        //3. view 전달
        model.addAttribute("members", memberEntity);
        return "members/show";
    }

}
