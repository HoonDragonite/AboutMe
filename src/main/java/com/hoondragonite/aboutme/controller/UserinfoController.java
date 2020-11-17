package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserinfoController {
    //GET,POST 모두 수행
    @RequestMapping(value="/userinfo")
    public String userInfo(Model model, HttpSession httpSession, HttpServletRequest httpServletRequest){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            System.out.println("사용자정보" + user.getUID());
            System.out.println("사용자정보" + user.getEmail());
            System.out.println("사용자정보" + user.getName());
            System.out.println("사용자정보" + user.getPicture());
            model.addAttribute("userName", user.getName());
        }

        System.out.println("My UserInfo *****************");
        System.out.println("korName : " + httpServletRequest.getParameter("korName"));
        System.out.println("engName : " + httpServletRequest.getParameter("engName"));
        System.out.println("email : " + httpServletRequest.getParameter("email"));
        System.out.println("contact : " + httpServletRequest.getParameter("contact"));
        System.out.println("blog : " + httpServletRequest.getParameter("blog"));
        System.out.println("selfIntroduce : " + httpServletRequest.getParameter("selfIntroduce"));
        return "userinfo";
    }
}
