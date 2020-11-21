package com.hoondragonite.aboutme.domain.careerinfo;

import com.hoondragonite.aboutme.config.auth.dto.CareerinfoDto;
import com.hoondragonite.aboutme.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Careerinfo extends CareerinfoDto{
    @Id
    //@GeneratedValue(generator="system-uuid")
   // @GenericGenerator(name="system-uuid", strategy = "uuid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cno;

    @Column(length=255, nullable = true)
    @ColumnDefault("-")
    private String cicarname;

    @Column(length=255, nullable = true)
    @ColumnDefault("-")
    private String cicomment;

    @Column(length = 8,nullable = true)
    @ColumnDefault("-")
    private String startdate;

    @Column(length = 8,nullable = true)
    @ColumnDefault("-")
    private String enddate;

//    @ManyToOne
//    @JoinColumn(name="user_info_uid",referencedColumnName="")
//    private User user;

    @Builder
    public Careerinfo(Long cno, String cicarname, String cicomment, String startdate, String enddate){
        this.cno = cno;
        this.cicarname = cicarname;
        this.cicomment = cicomment;
        this.startdate = startdate;
        this.enddate = enddate;
    }


}
