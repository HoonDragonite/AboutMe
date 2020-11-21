package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import com.hoondragonite.aboutme.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class WebRestController {

    private UserInfoService userInfoService;

    @PostMapping("/baseInfoSave") // RequestMapping + POST
    public Long saveUserInfo(@RequestBody UserInfoSaveRequestDto dto, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Long uID = null;

        if(user != null) {
            System.out.println("사용자정보" + user.getUID());
            System.out.println("사용자정보" + user.getEmail());
            System.out.println("사용자정보" + user.getName());
            System.out.println("사용자정보" + user.getPicture());

            uID = userInfoService.saveUserInfo(user.getUID(), dto);
        }

        return uID;
    }
}
