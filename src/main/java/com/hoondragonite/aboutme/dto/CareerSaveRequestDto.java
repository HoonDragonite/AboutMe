package com.hoondragonite.aboutme.dto;

import com.hoondragonite.aboutme.domain.career.Career;
import com.hoondragonite.aboutme.domain.project.Project;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CareerSaveRequestDto {
    private Long careerSeq;
    private String careerName;
    private String careerTeam;
    private String careerStartDate;
    private String careerEndDate;
    private String careerDesc;
    private String careerTechStack;
    private String careerMainTech;
    private String careerRole;

    @Builder
    public CareerSaveRequestDto(Long careerSeq, String careerName, String careerTeam, String careerStartDate, String careerEndDate, String careerDesc, String careerTechStack, String careerMainTech, String careerRole) {
        this.careerSeq = careerSeq;
        this.careerName = careerName;
        this.careerTeam = careerTeam;
        this.careerStartDate = careerStartDate;
        this.careerEndDate = careerEndDate;
        this.careerDesc = careerDesc;
        this.careerTechStack = careerTechStack;
        this.careerMainTech = careerMainTech;
        this.careerRole = careerRole;
    }

    public Career toEntity(){
        return Career.builder()
                .careerName(careerName)
                .careerTeam(careerTeam)
                .careerStartDate(careerStartDate)
                .careerEndDate(careerEndDate)
                .careerDesc(careerDesc)
                .careerTechStack(careerTechStack)
                .careerMainTech(careerMainTech)
                .careerRole(careerRole)
                .build();
    }
}
