package com.hoondragonite.aboutme.domain.userinfo;

import com.hoondragonite.aboutme.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserInfo extends BaseTimeEntity {
    @Id
    private Long uID;
    @Column(length = 30)
    private String korName;
    @Column(length = 30)
    private String engName;
    @Column(length = 50)
    private String email;
    @Column(length = 30)
    private String contact;
    @Column(length = 200)
    private String blog;
    @Column(length = 300)
    private String selfIntroduce;

    @Builder
    public UserInfo(String korName, String engName, String email, String contact, String blog, String selfIntroduce) {
        this.korName = korName;
        this.engName = engName;
        this.email = email;
        this.contact = contact;
        this.blog = blog;
        this.selfIntroduce = selfIntroduce;
    }

    public void setUID(Long uID){
        this.uID = uID;
    }

    public void updateUserInfo(String korName, String engName, String email, String contact, String blog, String selfIntroduce){
        this.korName = korName;
        this.engName = engName;
        this.email = email;
        this.contact = contact;
        this.blog = blog;
        this.selfIntroduce = selfIntroduce;
    }
}
