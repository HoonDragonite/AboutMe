package com.hoondragonite.aboutme.config.auth.dto;

import com.hoondragonite.aboutme.domain.careerinfo.Careerinfo;
import lombok.*;

import java.io.Serializable;

@Getter
@ToString
@NoArgsConstructor
public class CareerinfoDto implements Serializable {
    private Long cno;
    private String cicarname;
    private String cicomment;
    private String startdate;
    private String enddate;

    public CareerinfoDto(Careerinfo careerinfo){
        this.cno = careerinfo.getCno();
        this.cicarname = careerinfo.getCicarname();
        this.cicomment = careerinfo.getCicomment();
        this.startdate = careerinfo.getStartdate();
        this.enddate = careerinfo.getEnddate();
    }

}
