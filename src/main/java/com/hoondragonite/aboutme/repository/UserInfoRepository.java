package com.hoondragonite.aboutme.repository;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//<Entity타입, PK타입>
// findBy컬럼명 맞춰줘야 오류 안남
public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    Optional<UserInfo> findByuID(Long uID);
}
