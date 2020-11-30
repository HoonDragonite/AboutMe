package com.hoondragonite.aboutme.domain;

import com.hoondragonite.aboutme.domain.project.Project;
import com.hoondragonite.aboutme.repository.PjtRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PjtRepositoryTest {
    @Autowired
    PjtRepository pjtRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        pjtRepository.deleteAll();
    }

    @Test
    public void 사용자프로젝트_불러오기(){
        //given
        pjtRepository.save(Project.builder()
                .uID(new Long(1))
                .pjtName("어바웃미 프로젝트")
                .pjtTeam("훈나뇽")
                .pjtStartDate("202001")
                .pjtEndDate("202001")
                .pjtDesc("테스트용 내용입니다.")
                .pjtTechStack("Spring Boot")
                .pjtMainTech("메인기술")
                .pjtRole("개발자")
                .build());
        // when
        List<Project> projectList = pjtRepository.findAll();

        // then
        Project project = projectList.get(0);
        assertThat(project.getPjtName(), is("어바웃미 프로젝트"));
        System.out.println("테스트 확인 getPjtName() :" + project.getPjtName());
    }
}
