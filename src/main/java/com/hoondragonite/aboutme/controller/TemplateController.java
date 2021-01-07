package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.domain.career.Career;
import com.hoondragonite.aboutme.domain.project.Project;
import com.hoondragonite.aboutme.domain.template.Template;
import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.repository.TemplateRepository;
import com.hoondragonite.aboutme.service.CareerService;
import com.hoondragonite.aboutme.service.PjtService;
import com.hoondragonite.aboutme.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class TemplateController {
    private final TemplateRepository templateRepository;
    private UserInfoService userInfoService;
    private PjtService pjtService;
    private CareerService careerService;

    @RequestMapping(value="/template")
    public String template(Model model){
        List<Template> templateList = templateRepository.findAll();
        if(templateList.size() > 0) {
            model.addAttribute(templateList);
        }
        return "template";
    }

    @RequestMapping(value="/template/resume")
    public String resume(Model model, HttpSession httpSession){
        System.out.println("resume 컨트롤러");

        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        Optional<UserInfo> foundUserInfo = userInfoService.findByuID(user.getUID());
        if (foundUserInfo.isPresent()){
            UserInfo userInfo = foundUserInfo.get();
            System.out.println("이름 : " + userInfo.getKorName());
            model.addAttribute(userInfo);
        }

        List<Project> projectList = pjtService.findAllByuID(user.getUID());

        if(projectList.size() > 0){
            for(int i=0; i<projectList.size(); i++){
                System.out.println("Pjt명 : " + projectList.get(i).getPjtName());
            }

            model.addAttribute(projectList);
        }

        List<Career> careerList = careerService.findAllByuID(user.getUID());

        if(careerList.size() > 0){
            for(int i=0; i<careerList.size(); i++){
                System.out.println("Career명 : " + careerList.get(i).getCareerName());
            }
            model.addAttribute(careerList);
        }

        return "template/resume";
    }
}
