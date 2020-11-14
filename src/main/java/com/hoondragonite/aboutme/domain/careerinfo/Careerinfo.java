package com.hoondragonite.aboutme.domain.careerinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Careerinfo {
    @Id
    @GeneratedValue
    private String name;

    @Column(length=200, nullable = true)
    private String cicarname;

    @Column(length=500, nullable = true)
    private String cicomment;

    @Column(length = 8,nullable = true)
    private String startdate;

    @Column(length = 8,nullable = true)
    private String enddate;

    @Builder
    public Careerinfo(String name, String cicarname, String cicomment, String startdate, String enddate){
        this.name = name;
        this.cicarname = cicarname;
        this.cicomment = cicomment;
        this.startdate = startdate;
        this.enddate = enddate;
    }


}
