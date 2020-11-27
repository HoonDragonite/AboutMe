package com.hoondragonite.aboutme.dto;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;

@Getter
@Setter
@NoArgsConstructor
public class UserInfoSaveRequestDto {

    private String korName;
    private String engName;
    private String email;
    private String contact;
    private String blog;
    private String selfIntroduce;
    private String image;

    @Builder
    public UserInfoSaveRequestDto(String korName, String engName, String email,String contact, String blog, String selfIntroduce, String image){
        this.korName = korName;
        this.engName = engName;
        this.email = email;
        this.contact = contact;
        this.blog = blog;
        this.selfIntroduce = selfIntroduce;
        this.image = image;
    }
}
