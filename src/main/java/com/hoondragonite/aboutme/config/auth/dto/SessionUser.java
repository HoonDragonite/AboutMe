package com.hoondragonite.aboutme.config.auth.dto;

import java.io.Serializable;

import com.hoondragonite.aboutme.domain.user.User;
import lombok.Getter;

@Getter
public class SessionUser implements Serializable {
    private Long uID;
    private String name ;
    private String email ;
    private String picture ;

    public SessionUser(User user) {
        this.uID = user.getUID();
        this.name = user.getName() ;
        this.email = user.getEmail() ;
        this.picture = user.getPicture() ;
    }
}