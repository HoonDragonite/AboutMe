package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.CareerinfoDto;
import com.hoondragonite.aboutme.config.auth.service.CareerinfoService;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CareerinfoController {

    private CareerinfoService careerinfoService;

    public CareerinfoController(CareerinfoService careerinfoService){
        this.careerinfoService = careerinfoService;
    }

    @RequestMapping(value = "/cinfo")
    public String clist(){
        return "careerinfo.html";
    }

    @RequestMapping(value = "/cpost")
    public String post(){
        return "careerinfo.html";
    }

    @RequestMapping(value = "/cwrite")
    public String writecareer(CareerinfoDto careerinfoDto){
        careerinfoService.saveCareer(careerinfoDto);
        return "careerinfo.html";
    }

}
