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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cno;

    @Column(length=200, nullable = true)
    private String cicarname;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String cicomment;

    @Column(length = 8,nullable = true)
    private String startdate;

    @Column(length = 8,nullable = true)
    private String enddate;

    @Builder
    public Careerinfo(int cno, String cicarname, String cicomment, String startdate, String enddate){
        this.cno = cno;
        this.cicarname = cicarname;
        this.cicomment = cicomment;
        this.startdate = startdate;
        this.enddate = enddate;
    }


}
