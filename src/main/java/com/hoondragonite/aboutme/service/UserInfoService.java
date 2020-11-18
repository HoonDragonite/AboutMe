package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    @Transactional
    public Optional<UserInfo> findByuID(Long uID){
        return userInfoRepository.findByuID(uID);
    }

    @Transactional
    public void save(UserInfoSaveRequestDto dto){
        userInfoRepository.save(dto.toEntity());
    }
}
