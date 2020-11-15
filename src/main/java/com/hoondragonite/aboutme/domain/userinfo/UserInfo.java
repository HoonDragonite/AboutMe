package com.hoondragonite.aboutme.domain.userinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity(name = "UserInfo")
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long uInfoID;
    @Column
    private String korName;
    @Column
    private String engName;
    @Column
    private String email;
    @Column
    private String contact;
    @Column
    private String contact2;
    @Column
    private String address;
    @Column
    private String blog;

    @Builder
    public UserInfo(String korName, String engName, String email, String contact, String contact2, String address, String blog) {
        this.korName = korName;
        this.engName = engName;
        this.email = email;
        this.contact = contact;
        this.contact2 = contact2;
        this.address = address;
        this.blog = blog;
    }
    
    //Setter 대신 작성하는 메소드
    public UserInfo setUserInfo(String korName, String engName, String email, String contact, String contact2, String address, String blog) {
        this.korName = korName;
        this.engName = engName;
        this.email = email;
        this.contact = contact;
        this.contact2 = contact2;
        this.address = address;
        this.blog = blog;
        return this;
    }
}
