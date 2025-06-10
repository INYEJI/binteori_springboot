package com.example.fristproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrirstController {

    @GetMapping("/hi")
    public String hi(Model model) {
        model.addAttribute("username", "김대철");
        return "greetings";
    }

    @GetMapping("/bye")
    public String bye(Model model) {
        model.addAttribute("nickname", "김대철");
        return "goodbye";
    }
}
