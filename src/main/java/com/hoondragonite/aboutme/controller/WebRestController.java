package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.service.UserInfoService;
// import com.hoondragonite.aboutme.util.S3Uploader;
import com.hoondragonite.aboutme.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@AllArgsConstructor
public class WebRestController {

    private S3Service s3Service;
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

    @PostMapping("/profileUpload")
    @ResponseBody
    public String uploadImage(@RequestParam("data") MultipartFile multipartFile) throws IOException {
        System.out.println("uploadImage");
        return s3Service.upload(multipartFile, "abtme_profile");
    }

}
