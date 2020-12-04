package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.project.Project;
import com.hoondragonite.aboutme.dto.PjtSaveRequestDto;
import com.hoondragonite.aboutme.repository.PjtRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PjtServiceTest {
    @Autowired
    private PjtService pjtService;
    @Autowired
    private PjtRepository pjtRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        pjtRepository.deleteAll();
    }

    @Test
    public void 사용자프로젝트_행이_0일_때(){
        // given
        Long testUID = new Long(1);
        // when
        Optional<Project> projectOptional = pjtService.findByuID(testUID);
        List<Project>projectList = pjtService.findAllByuID(testUID);
        //then
        if(projectOptional.isPresent()){
            System.out.println("projectOptional : 행이 있습니다.");
        }
        else{
            System.out.println("projectOptional : 행이 없습니다.");
        }

        System.out.println("projectList size: " + projectList.size());
        System.out.println("projectList isEmpty: " + projectList.isEmpty());
    }

    @Test
    public void 사용자프로젝트_서비스_테스트_단일(){
        // given
        Long testUID = new Long(1);
        PjtSaveRequestDto dto = PjtSaveRequestDto.builder()
                .uID(new Long(1))
                .pjtName("어바웃미 프로젝트")
                .pjtTeam("훈나뇽")
                .pjtStartDate("202001")
                .pjtEndDate("202001")
                .pjtDesc("테스트용 내용입니다.")
                .pjtTechStack("Spring Boot")
                .pjtMainTech("메인기술")
                .pjtRole("개발자")
                .build();
        pjtService.savePjt(testUID, dto);

        // when
        Optional<Project> foundProjectList = pjtService.findByuID(testUID);

        // then
        if(foundProjectList.isPresent()){
            Project project =foundProjectList.get();

            assertThat(project.getPjtName(), is("어바웃미 프로젝트"));
            System.out.println("테스트 확인 getPjtName() :" + project.getPjtName());
        }
    }

    @Test
    public void 사용자프로젝트_서비스_테스트_복수(){
        // given
        Long testUID = new Long(1);
        List<PjtSaveRequestDto> dtoList = new ArrayList<>();

        PjtSaveRequestDto dto = PjtSaveRequestDto.builder()
                .uID(new Long(1))
                .pjtName("프로젝트1 수정")
                .pjtTeam("훈나뇽")
                .pjtStartDate("202001")
                .pjtEndDate("202001")
                .pjtDesc("테스트용 내용입니다.")
                .pjtTechStack("Spring Boot")
                .pjtMainTech("메인기술")
                .pjtRole("개발자")
                .build();

        PjtSaveRequestDto dto1 = PjtSaveRequestDto.builder()
                .uID(null)
                .pjtName("프로젝트2 저장")
                .pjtTeam("훈나뇽")
                .pjtStartDate("202001")
                .pjtEndDate("202001")
                .pjtDesc("테스트용 내용입니다.")
                .pjtTechStack("Spring Boot")
                .pjtMainTech("메인기술")
                .pjtRole("개발자")
                .build();

        PjtSaveRequestDto dto2 = PjtSaveRequestDto.builder()
                .uID(null)
                .pjtName("")
                .pjtTeam("")
                .pjtStartDate("")
                .pjtEndDate("")
                .pjtDesc("")
                .pjtTechStack("")
                .pjtMainTech("")
                .pjtRole("")
                .build();

        dtoList.add(dto);
        dtoList.add(dto1);
        dtoList.add(dto2);

        // when
        pjtService.savePjtList(new Long(1), dtoList);

        // then
        List<Project> projectList = pjtService.findAllByuID(testUID);

        for (int i=0; i< projectList.size(); i++){
            System.out.println("꺼낸 프로젝트 " + i + "번째 :" + projectList.get(i).getPjtName());
        }
    }

    @Test
    public void 사용자_프로젝트_여러개_꺼내오기(){
        // given
        Long uID;
        Long testUID = new Long(1);
        PjtSaveRequestDto dto = PjtSaveRequestDto.builder()
                .uID(new Long(1))
                .pjtName("어바웃미 프로젝트")
                .pjtTeam("훈나뇽")
                .pjtStartDate("202001")
                .pjtEndDate("202001")
                .pjtDesc("테스트용 내용입니다.")
                .pjtTechStack("Spring Boot")
                .pjtMainTech("메인기술")
                .pjtRole("개발자")
                .build();
        pjtService.savePjt(testUID, dto);

        PjtSaveRequestDto dto2 = PjtSaveRequestDto.builder()
                .uID(new Long(1))
                .pjtName("어바웃미 프로젝트222")
                .pjtTeam("훈나뇽")
                .pjtStartDate("202002")
                .pjtEndDate("202002")
                .pjtDesc("테스트용 내용입니다.2222")
                .pjtTechStack("Spring Boot22")
                .pjtMainTech("메인기술222")
                .pjtRole("개발자222")
                .build();
        pjtService.savePjt(testUID, dto2);

        // when
        List<Project> projectList = pjtService.findAllByuID(testUID);

        //then
        for (int i=0; i< projectList.size(); i++){
            System.out.println("꺼낸 프로젝트 " + i + "번째 :" + projectList.get(i).getPjtName());
        }
    }
}
