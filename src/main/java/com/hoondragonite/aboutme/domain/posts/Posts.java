package com.hoondragonite.aboutme.domain.posts;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/*
* Class Name : Posts
* Writer     : 이승훈
* Desc       : Entity 클래스, 실제 DB와 매칭될 Class 이다.
* Setter 메소드를 통해 값을 변환하지 말고 목적과 의도가 있는 메소드를 작성하자.
*
* */


@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본생성자 자동 추가, 접근 권한은 PROTECTED로 제한
@Getter // 클래스 내 모든 필드의 Getter 메소드 생성
@Entity // Table과 링크될 Class
public class Posts {

    @Id // PK
    @GeneratedValue // PK 생성규칙, 기본값은 Auto, 자동증가
    private Long id;

    @Column(length = 500, nullable = false) //@Column 선언 안해도 컬럼이 되지만 옵션을 변경하고 싶을 때 선언
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더패턴 클래스를 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}