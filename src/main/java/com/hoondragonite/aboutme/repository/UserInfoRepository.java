package com.hoondragonite.aboutme.repository;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

//<Entity타입, PK타입>
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}
