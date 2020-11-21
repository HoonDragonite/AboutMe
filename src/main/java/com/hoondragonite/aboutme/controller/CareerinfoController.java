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

    //목록조회
    @RequestMapping(value = "/cinfo")
    public String careerinfo(Model model){
        List cdtolist = careerinfoService.getCareerList();
        model.addAttribute("clist",cdtolist);
        System.out.println("careerinfoService.getCareerList() > "+cdtolist);

        return "careerinfo";
    }

    @PostMapping("/savecareer")
    public String saveCareer(@RequestBody Careerinfo careerinfo) throws Exception{
        careerinfoService.saveCareer(careerinfo);
        return "careerinfo";
    }

    //경력수정
//    @GetMapping("modifycareer")
//    public String modifycareer(@PathVariable("cno") Long cno,Model model)throws Exception{
//        CareerinfoDto dto = careerinfoService.updateCareer(cno);
//        model.addAttribute("cdto",dto);
//        return "careerinfo";
//    }


    //경력삭제
//    @RequestMapping(value = "/deletecareer/{cno}")
//    public void deletecareer(@PathVariable("cno") Long cno) throws Exception{
//        System.out.println("deletecareer cno > "+cno);
//        careerinfoService.deleteCareer(cno);
//    }


}
