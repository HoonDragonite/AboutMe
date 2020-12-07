package com.hoondragonite.aboutme.dto;

import com.hoondragonite.aboutme.domain.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PjtSaveRequestDto {

    private Long pjtSeq;
    private String pjtName;
    private String pjtTeam;
    private String pjtStartDate;
    private String pjtEndDate;
    private String pjtDesc;
    private String pjtTechStack;
    private String pjtMainTech;
    private String pjtRole;

    @Builder
    public PjtSaveRequestDto(Long pjtSeq, String pjtName, String pjtTeam, String pjtStartDate, String pjtEndDate, String pjtDesc, String pjtTechStack, String pjtMainTech, String pjtRole) {
        this.pjtSeq = pjtSeq;
        this.pjtName = pjtName;
        this.pjtTeam = pjtTeam;
        this.pjtStartDate = pjtStartDate;
        this.pjtEndDate = pjtEndDate;
        this.pjtDesc = pjtDesc;
        this.pjtTechStack = pjtTechStack;
        this.pjtMainTech = pjtMainTech;
        this.pjtRole = pjtRole;
    }

    public Project toEntity(){
        return Project.builder()
                .pjtName(pjtName)
                .pjtTeam(pjtTeam)
                .pjtStartDate(pjtStartDate)
                .pjtEndDate(pjtEndDate)
                .pjtDesc(pjtDesc)
                .pjtTechStack(pjtTechStack)
                .pjtMainTech(pjtMainTech)
                .pjtRole(pjtRole)
                .build();
    }
}
