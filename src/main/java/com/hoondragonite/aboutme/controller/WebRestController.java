package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    private UserInfoRepository userInfoRepository; // Bean 객체를 생성자로 주입

    @PostMapping("/userInfoSave") // RequestMapping + POST 방식
    public void saveUserInfo(@RequestBody UserInfoSaveRequestDto dto){
        System.out.println("userInfoSave Test*********");
        UserInfo testing = dto.toEntity();
        System.out.println(testing.getUID());
        System.out.println(testing.getKorName());
        System.out.println(testing.getEngName());
        System.out.println(testing.getEmail());
        System.out.println(testing.getContact());
        System.out.println(testing.getBlog());
        System.out.println(testing.getSelfIntroduce());
        System.out.println("userInfoSave Test 끝*********");
        //userInfoRepository.save(dto.toEntity());
    }
}
