package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.domain.career.Career;
import com.hoondragonite.aboutme.domain.project.Project;
import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.service.CareerService;
import com.hoondragonite.aboutme.service.PjtService;
import com.hoondragonite.aboutme.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserInfoController {
    private UserInfoService userInfoService;
    private PjtService pjtService;
    private CareerService careerService;
    @RequestMapping(value="/userinfo")
    public String userInfo(Model model, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        Optional<UserInfo> foundUserInfo = userInfoService.findByuID(user.getUID());
        if (foundUserInfo.isPresent()){
            UserInfo userInfo = foundUserInfo.get();
            model.addAttribute(userInfo);
        }

        List<Project> projectList = pjtService.findAllByuID(user.getUID());

        if(projectList.size() > 0){
            model.addAttribute(projectList);
        }

        List<Career> careerList = careerService.findAllByuID(user.getUID());

        if(careerList.size() > 0){
            model.addAttribute(careerList);
        }
        return "userinfo";
    }
}
