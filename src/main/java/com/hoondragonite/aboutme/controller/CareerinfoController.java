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

import java.util.ArrayList;
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
//        List cdtolist = new ArrayList();
//        cdtolist = careerinfoService.getCareerList();
//        model.addAttribute("clist",cdtolist);
//        System.out.println("careerinfoService.getCareerList() > "+cdtolist);

        return "careerinfo";
    }

    @RequestMapping(value="getcareerlist")
    @ResponseBody
    public List<CareerinfoDto> getcareer(@RequestParam Map<String,Object> paramMap,Model model){
        return careerinfoService.getCareerList();
    }

    //저장
    @PostMapping("/savecareer")
    public String saveCareer(@RequestBody Careerinfo careerinfo) throws Exception{
        careerinfoService.saveCareer(careerinfo);
        return "careerinfo";
    }

    @RequestMapping("/careermodify")
    public String careermodify(@PathVariable("cno") Long cno)throws Exception{
        System.out.println("careermodify cno > "+cno);

        return "careerinfo";
    }



    //경력수정
    @RequestMapping("/modifycareer")
    //@ResponseBody
    public String modifycareer(@RequestBody Careerinfo careerinfo,@PathVariable("cno") Long cno)throws Exception{
        careerinfoService.modifyCareer(careerinfo);
        System.out.println("modifycareer cno > "+cno);
        System.out.println("modifycareer careerinfo > "+careerinfo);

         //return careerinfoService.modifyCareer(careerinfo);
        return "careerinfo";
    }



    //경력삭제
    @RequestMapping(value = "/deletecareer/{cno}")
    @ResponseBody
    public String deletecareer(@PathVariable("cno") Long cno) throws Exception{
        System.out.println("deletecareer cno > "+cno);
        careerinfoService.deleteCareer(cno);
        return "careerinfo";
    }


}
