package com.hoondragonite.aboutme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.net.http.HttpRequest;

@Controller
public class IndexController {

    @GetMapping("/")
    public String empty(Model model){
        return "index";
    }

    @RequestMapping(value = "/template")
    public String moveToSelect(ModelAndView modelAndView){ return "template";}

    @RequestMapping(value = "/login")
    public String moveToLogin(ModelAndView modelAndView){
        return "login";
    }
}