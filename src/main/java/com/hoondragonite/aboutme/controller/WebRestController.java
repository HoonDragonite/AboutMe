package com.hoondragonite.aboutme.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @GetMapping("/test")
    public String test(){
        return "Hello World";
    }
}
