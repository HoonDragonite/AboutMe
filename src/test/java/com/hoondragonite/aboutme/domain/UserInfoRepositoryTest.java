package com.hoondragonite.aboutme.domain;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoRepositoryTest {

    @Autowired
    UserInfoRepository userInfoRepository;

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
    public void 사용자정보저장_불러오기() {
        //given : 테스트 기반 환경 작성
        userInfoRepository.save(UserInfo.builder()
                .korName("이승훈")
                .engName("SeungHoon Lee")
                .email("a@naver.com")
                .contact("010-1234-1234")
                .blog("a.com")
                .selfIntroduce("hello")
                .build());

        //when : 테스트 하고자 하는 행위
        List<UserInfo> userInfoList = userInfoRepository.findAll();

        //then : 테스트 결과 검증
        UserInfo userInfo = userInfoList.get(0);
        assertThat(userInfo.getKorName(), is("이승훈"));
        assertThat(userInfo.getEngName(), is("SeungHoon Lee"));
    }
}