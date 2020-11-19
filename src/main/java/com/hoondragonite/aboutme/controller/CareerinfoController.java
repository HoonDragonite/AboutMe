package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.CareerinfoDto;
import com.hoondragonite.aboutme.config.auth.service.CareerinfoService;
import com.hoondragonite.aboutme.domain.careerinfo.Careerinfo;
import com.hoondragonite.aboutme.repository.CareerinfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CareerinfoController {

    private CareerinfoService careerinfoService;
    private CareerinfoRepository careerinfoRepository;

    public CareerinfoController(CareerinfoService careerinfoService){
        this.careerinfoService = careerinfoService;
    }

    @RequestMapping(value = "/cinfo")
    public String clist(Model model, CareerinfoDto careerinfoDto){
        //List<CareerinfoDto> cdtolist = careerinfoService.getCareerList();
        //careerinfoDto.getCno();
        //model.addAttribute("clist",cdtolist);
        return "careerinfo";
    }

    @RequestMapping("/savecareer")
    @ResponseBody
    public void writeCareer(Model model, CareerinfoDto careerinfoDto) throws Exception{
        System.out.println("careerinfoDto > "+careerinfoDto);
        careerinfoService.saveCareer(careerinfoDto);
        model.addAttribute("careerinfo",careerinfoDto.getCno());

        Map<String,String> careerDto = new HashMap<>();
        careerDto.put("cname",careerinfoDto.getCicarname());
        careerDto.put("cment",careerinfoDto.getCicomment());
        careerDto.put("sdate",careerinfoDto.getStartdate());
        careerDto.put("edate",careerinfoDto.getEnddate());
        System.out.println("dto > "+careerinfoDto);
        System.out.println("careerDto > "+careerDto);
        //return "careerinfo";
    }

    @RequestMapping(value = "/deletecareer")
    public String deletecareer(@RequestParam(value = "cno",required = false) Long cno) throws Exception{
        return "";
    }


}
