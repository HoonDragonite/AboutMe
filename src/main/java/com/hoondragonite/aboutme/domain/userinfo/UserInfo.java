package com.hoondragonite.aboutme.domain.userinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uInfoID;
    @Column(nullable = false)
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
    public UserInfo(Long uID, String korName, String engName, String email, String contact, String blog, String selfIntroduce) {
        this.uID = uID;
        this.korName = korName;
        this.engName = engName;
        this.email = email;
        this.contact = contact;
        this.blog = blog;
        this.selfIntroduce = selfIntroduce;
    }
}
