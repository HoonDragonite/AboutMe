package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.career.Career;
import com.hoondragonite.aboutme.dto.CareerSaveRequestDto;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.CareerRepository;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import lombok.AllArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CareerService {
    @PersistenceContext
    EntityManager em;

    private final CareerRepository careerRepository;

    @Transactional
    public List<Career> findAllByuID(Long uID){
        return  careerRepository.findAllByuID(uID);
    }

    @Transactional
    public Optional<Career> findByuID(Long uID){
        return careerRepository.findByuID(uID);
    }


    @Transactional
    public Long saveCareer(Long uID, CareerSaveRequestDto dto){
        pushCareer(uID, dto);
        return uID;
    }

    @Transactional
    public Long saveCareerList(Long uID, List<CareerSaveRequestDto> dtoList){
        CareerSaveRequestDto dto;
        for(int i=0; i<dtoList.size(); i++){
            dto = dtoList.get(i);
            if(dto.getCareerName().equals("")){
                continue;
            }
            pushCareer(uID, dto);
        }

        return uID;
    }

    private void pushCareer(Long uID, CareerSaveRequestDto dto) {
        if(dto.getCareerSeq() == null){
            Career newEntity = dto.toEntity();
            newEntity.setUID(uID);
            careerRepository.save(newEntity);
        }
        else{
            Optional<Career> optionalCareer =careerRepository.findById(dto.getCareerSeq());
            if(optionalCareer.isPresent()){
                Career updateEntity = optionalCareer.get();
                System.out.println("updateEntity getUID:" + updateEntity.getUID());
                updateEntity.updateCareer(dto.getCareerName(),dto.getCareerTeam(),dto.getCareerStartDate(),dto.getCareerEndDate(),dto.getCareerDesc(),dto.getCareerTechStack(),dto.getCareerMainTech(),dto.getCareerRole());
                System.out.println("updateEntity getUID:" + updateEntity.getUID());
                careerRepository.save(updateEntity);
            }
        }
    }

    @Transactional
    public void deleteCareer(CareerSaveRequestDto dto){
        System.out.println("서비스 : "+ dto.getCareerSeq());
        careerRepository.deleteByCareerSeq(dto.getCareerSeq());
    }
}
