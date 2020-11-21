package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.userinfo.UserInfo;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@AllArgsConstructor
@Service
public class UserInfoService {
    @PersistenceContext
    EntityManager em;

    private final UserInfoRepository userInfoRepository;

    @Transactional
    public Optional<UserInfo> findByuID(Long uID){
        return userInfoRepository.findByuID(uID);
    }

    @Transactional
    public Long saveUserInfo(Long uID, UserInfoSaveRequestDto dto){
        Optional<UserInfo> toSave = findByuID(uID);
        if(toSave.isPresent()){ // 정보만 Update
            UserInfo userInfo = toSave.get();
            userInfo.updateUserInfo(dto.getKorName(), dto.getEngName(), dto.getEmail(), dto.getContact(), dto.getBlog(), dto.getSelfIntroduce());
            userInfoRepository.save(userInfo);
            return userInfo.getUID();
        }
        else{ // 새로 생성하여 Insert
            UserInfo newUserInfo = new UserInfo();
            newUserInfo.setUID(uID);
            newUserInfo.updateUserInfo(dto.getKorName(), dto.getEngName(), dto.getEmail(), dto.getContact(), dto.getBlog(), dto.getSelfIntroduce());
            em.persist(newUserInfo);
            userInfoRepository.save(newUserInfo);
            return newUserInfo.getUID();
        }


    }
}
