package com.hoondragonite.aboutme.domain.project;

import com.hoondragonite.aboutme.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Project extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pjtSeq;
    @Column
    private Long uID;
    @Column(length = 50)
    private String pjtName;
    @Column(length = 50)
    private String pjtTeam;
    @Column(length = 6)
    private String pjtStartDate;
    @Column(length = 6)
    private String pjtEndDate;
    @Column(length = 200)
    private String pjtDesc;
    @Column(length = 200)
    private String pjtTechStack;
    @Column(length = 200)
    private String pjtMainTech;
    @Column(length = 200)
    private String pjtRole;

    @Builder
    public Project(Long uID, String pjtName, String pjtTeam, String pjtStartDate, String pjtEndDate, String pjtDesc, String pjtTechStack, String pjtMainTech, String pjtRole) {
        this.uID = uID;
        this.pjtName = pjtName;
        this.pjtTeam = pjtTeam;
        this.pjtStartDate = pjtStartDate;
        this.pjtEndDate = pjtEndDate;
        this.pjtDesc = pjtDesc;
        this.pjtTechStack = pjtTechStack;
        this.pjtMainTech = pjtMainTech;
        this.pjtRole = pjtRole;
    }

    public void updateProject(Long uID, String pjtName, String pjtTeam, String pjtStartDate, String pjtEndDate, String pjtDesc, String pjtTechStack, String pjtMainTech, String pjtRole) {
        this.uID = uID;
        this.pjtName = pjtName;
        this.pjtTeam = pjtTeam;
        this.pjtStartDate = pjtStartDate;
        this.pjtEndDate = pjtEndDate;
        this.pjtDesc = pjtDesc;
        this.pjtTechStack = pjtTechStack;
        this.pjtMainTech = pjtMainTech;
        this.pjtRole = pjtRole;
    }

    public void setUID(Long uID){
        this.uID = uID;
    }
}
