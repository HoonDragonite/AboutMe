package com.hoondragonite.aboutme.domain.career;

import com.hoondragonite.aboutme.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Career extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long careerSeq;
    @Column
    private Long uID;
    @Column(length = 50)
    private String careerName;
    @Column(length = 50)
    private String careerTeam;
    @Column(length = 6)
    private String careerStartDate;
    @Column(length = 6)
    private String careerEndDate;
    @Column(length = 200)
    private String careerDesc;
    @Column(length = 200)
    private String careerTechStack;
    @Column(length = 200)
    private String careerMainTech;
    @Column(length = 200)
    private String careerRole;

    @Builder
    public Career(Long uID, String careerName, String careerTeam, String careerStartDate, String careerEndDate, String careerDesc, String careerTechStack, String careerMainTech, String careerRole) {
        this.uID = uID;
        this.careerName = careerName;
        this.careerTeam = careerTeam;
        this.careerStartDate = careerStartDate;
        this.careerEndDate = careerEndDate;
        this.careerDesc = careerDesc;
        this.careerTechStack = careerTechStack;
        this.careerMainTech = careerMainTech;
        this.careerRole = careerRole;
    }

    public void updateCareer(String careerName, String careerTeam, String careerStartDate, String careerEndDate, String careerDesc, String careerTechStack, String careerMainTech, String careerRole){
        this.careerName = careerName;
        this.careerTeam = careerTeam;
        this.careerStartDate = careerStartDate;
        this.careerEndDate = careerEndDate;
        this.careerDesc = careerDesc;
        this.careerTechStack = careerTechStack;
        this.careerMainTech = careerMainTech;
        this.careerRole = careerRole;
    }

    public void setUID(Long uID){
        this.uID = uID;
    }
}
