package com.hoondragonite.aboutme.domain.template;

import com.hoondragonite.aboutme.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Template extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long templateSeq;
    @Column(length = 50)
    private String templateName;
    @Column(length = 200)
    private String templateDesc;
    @Column(length = 100)
    private String templateImage;
    @Column(length = 50)
    private String templateHref;
}
