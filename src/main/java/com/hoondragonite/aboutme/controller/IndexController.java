package com.hoondragonite.aboutme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String empty(Model model){
        model.addAttribute("test", "empty SeungHoon");
        return "index";
    }

    @GetMapping("/index")
    public String index(Model model){
        model.addAttribute("test", "index SeungHoon");
        return "index";
    }
}
