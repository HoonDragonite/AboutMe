package com.hoondragonite.aboutme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class WebRestController {

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }

    @RequestMapping(value = "/back", method = RequestMethod.GET)
    public String test(HttpServletRequest request){
        String referer = request.getHeader("Referer");
        return "redirect:"+ referer;
    }
}
