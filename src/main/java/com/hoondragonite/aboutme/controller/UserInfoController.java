package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserInfoController {
    private UserInfoService userInfoService;

    @RequestMapping(value="/userinfo")
    public String userInfo(Model model, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            model.addAttribute("userName", user.getName());
        }

        Optional<UserInfo> foundUserInfo = userInfoService.findByuID(user.getUID());
        if (foundUserInfo.isPresent()){
            UserInfo userInfo = foundUserInfo.get();
            System.out.println("찾은 사용자정보 : " + userInfo.getUID());
            System.out.println("찾은 사용자정보 : " + userInfo.getKorName());
            System.out.println("찾은 사용자정보 : " + userInfo.getEngName());
            System.out.println("찾은 사용자정보 : " + userInfo.getEmail());
            System.out.println("찾은 사용자정보 : " + userInfo.getContact());
            System.out.println("찾은 사용자정보 : " + userInfo.getBlog());
            System.out.println("찾은 사용자정보 : " + userInfo.getSelfIntroduce());
            model.addAttribute(userInfo);
        }

        return "userinfo";
    }
    /*


     */
}
