package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.CareerinfoDto;
import com.hoondragonite.aboutme.config.auth.service.CareerinfoService;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

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


//    @RequestMapping(value = "/savecareer")
//    public String savecareer(CareerinfoDto careerinfoDto, RedirectAttributes redirectAttributes){
//        careerinfoService.saveCareer(careerinfoDto);
//        //redirectAttributes.addFlashAttribute("careerinfoDto",careerinfoDto);
//        return "redirect:/cinfo";
//    }


//    @RequestMapping(value = "/savecareer")
//    @ResponseBody
//    public String savecareer(@ModelAttribute CareerinfoDto careerinfoDto){
//        careerinfoService.saveCareer(careerinfoDto);
//        Map<String,String> careerDto = new HashMap<>();
//        careerDto.put("cname",careerinfoDto.getCicarname());
//        careerDto.put("cment",careerinfoDto.getCicomment());
//        careerDto.put("sdate",careerinfoDto.getStartdate());
//        careerDto.put("edate",careerinfoDto.getEnddate());
//
//        return careerDto;
//    }



    @RequestMapping(value = "/savecareer")
    @ResponseBody
    public String savecareer(MultipartHttpServletRequest request) throws Exception {

        CareerinfoDto careerDto = new CareerinfoDto();

        String cname = request.getParameter("cname");
        String cment = request.getParameter("cment");
        String sdate = request.getParameter("sdate");
        String edate = request.getParameter("edate");

        careerDto.setCicarname(cname);
        careerDto.setCicomment(cment);
        careerDto.setStartdate(sdate);
        careerDto.setEnddate(edate);
        careerinfoService.saveCareer(careerDto);
        return "ok";
    }



    @RequestMapping(value = "/deletecareer")
    public String deletecareer(@RequestParam(value = "cno",required = false) Integer cno) throws Exception{
        return "";
    }


}
