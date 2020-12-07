package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.dto.PjtSaveRequestDto;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.service.PjtService;
import com.hoondragonite.aboutme.service.UserInfoService;
// import com.hoondragonite.aboutme.util.S3Uploader;
import com.hoondragonite.aboutme.service.S3Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@RestController
@AllArgsConstructor
public class WebRestController {

    private S3Service s3Service;
    private UserInfoService userInfoService;
    private PjtService pjtService;

    @PostMapping("/baseInfoSave")
    public Long saveUserInfo(@RequestBody UserInfoSaveRequestDto dto, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Long uID = null;

        if(user != null) {
            System.out.println("Save Image" + dto.getImage());

            uID = userInfoService.saveUserInfo(user.getUID(), dto);
        }

        return uID;
    }

    @PostMapping("/profileUpload")
    @ResponseBody
    public String uploadImage(@RequestParam("data") MultipartFile multipartFile, HttpSession httpSession) throws IOException {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Long uID = null;

        if(user != null) {
            uID = user.getUID();
        }

        return s3Service.upload(multipartFile, "abtme_profile", uID);
    }

    @PostMapping("pjtSave")
    public void pjtSave(@RequestBody PjtSaveRequestDto dto, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Long uID = null;

        if(user != null) {
            pjtService.savePjt(user.getUID(), dto);
        }
    }

    @PostMapping("/pjtListSave")
    public Long pjtListSave(@RequestBody List<PjtSaveRequestDto> dtoList, HttpSession httpSession){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Long uID = null;

        if(user != null) {
            uID = pjtService.savePjtList(user.getUID(), dtoList);
        }

        return uID;
    }
}
