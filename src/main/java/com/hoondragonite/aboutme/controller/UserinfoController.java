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
    public String userInfo(Model model, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            System.out.println("사용자정보" + user.getUID());
            System.out.println("사용자정보" + user.getEmail());
            System.out.println("사용자정보" + user.getName());
            System.out.println("사용자정보" + user.getPicture());
            model.addAttribute("userName", user.getName());
        }


        return "userinfo";
    }
}
