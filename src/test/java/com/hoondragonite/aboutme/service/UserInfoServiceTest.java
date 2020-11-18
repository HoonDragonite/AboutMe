package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceTest {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserInfoRepository userInfoRepository;

    @After
    public void cleanup() {
        /**
         이후 테스트 코드에 영향을 끼치지 않기 위해
         테스트 메소드가 끝날때 마다 respository 전체 비우는 코드
         **/
        userInfoRepository.deleteAll();
    }

    /* 왼쪽 밑에 초록버튼으로 메소드 실행해보기*/
    @Test
    public void 사용자정보_찾기() {
        //given : 테스트 기반 환경 작성
        userInfoService.save(UserInfoSaveRequestDto.builder()
                .uID(new Long(1))
                .korName("이승훈")
                .engName("SeungHoon Lee")
                .email("a@naver.com")
                .contact("010-1234-1234")
                .blog("a.com")
                .selfIntroduce("hello")
                .build());

        //when : 테스트 하고자 하는 행위
        Optional<UserInfo> userInfo = userInfoService.findByuID(new Long(1));
        //then : 테스트 결과 검증

        assertThat(userInfo.get().getKorName(), is("이승훈"));
        System.out.println("테스트결과" + userInfo.get().getKorName());
    }
}