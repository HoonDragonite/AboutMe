package com.hoondragonite.aboutme.domain.careerinfo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Careerinfo {
    @Id
    //@GeneratedValue(generator="system-uuid")
   // @GenericGenerator(name="system-uuid", strategy = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    @Column(length=255, nullable = true)
    private String cicarname;

    @Column(length=255, nullable = true)
    private String cicomment;

    @Column(length = 8,nullable = true)
    private String startdate;

    @Column(length = 8,nullable = true)
    private String enddate;

    @Builder
    public Careerinfo(Long cno, String cicarname, String cicomment, String startdate, String enddate){
        this.cno = cno;
        this.cicarname = cicarname;
        this.cicomment = cicomment;
        this.startdate = startdate;
        this.enddate = enddate;
    }


}
