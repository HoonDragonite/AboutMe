package com.hoondragonite.aboutme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    @GetMapping("/")
    public String empty(Model model){
        model.addAttribute("test", "empty SeungHoon");
        System.out.println("Move to index");
        return "index";
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String moveToSelect(ModelAndView modelAndView){
        System.out.println("RequestMapping TEST : moveToselect, value = ./select");
        return "select";
    }

}