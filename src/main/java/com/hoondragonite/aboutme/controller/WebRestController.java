package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@AllArgsConstructor
public class WebRestController {

    private UserInfoRepository userInfoRepository; // Bean 객체를 생성자로 주입

    @PostMapping("/userInfoSave") // RequestMapping + POST 방식
    public void saveUserInfo(@RequestBody UserInfoSaveRequestDto dto, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        if(user != null) {
            System.out.println("사용자정보" + user.getUID());
            System.out.println("사용자정보" + user.getEmail());
            System.out.println("사용자정보" + user.getName());
            System.out.println("사용자정보" + user.getPicture());

            dto.setUID(user.getUID());
        }

        System.out.println("userInfoSave Test*********");
        UserInfo test = dto.toEntity();
        System.out.println(test.getUID());
        System.out.println(test.getKorName());
        System.out.println(test.getEngName());
        System.out.println(test.getEmail());
        System.out.println(test.getContact());
        System.out.println(test.getBlog());
        System.out.println(test.getSelfIntroduce());
        System.out.println("userInfoSave Test 끝*********");

        //userInfoRepository.save(dto.toEntity());
    }
}
