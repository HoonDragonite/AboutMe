package com.hoondragonite.aboutme.dto;

import com.hoondragonite.aboutme.config.auth.dto.SessionUser;
import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
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

    private Long uID;
    private String korName;
    private String engName;
    private String email;
    private String contact;
    private String blog;
    private String selfIntroduce;

    public UserInfo toEntity(){

        System.out.println("toEntity*******************");
        System.out.println(korName);
        System.out.println(engName);
        System.out.println(email);
        System.out.println(contact);
        System.out.println(blog);
        System.out.println(selfIntroduce);
        System.out.println("toEntity 끝*******************");

        ServletRequestAttributes servletRequestAttribute = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession httpSession = servletRequestAttribute.getRequest().getSession(true);

        SessionUser user = (SessionUser) httpSession.getAttribute("user");


        return UserInfo.builder()
                .uID(user.getUID())
                .korName(korName)
                .engName(engName)
                .email(email)
                .contact(contact)
                .blog(blog)
                .selfIntroduce(selfIntroduce)
                .build();
    }
}
