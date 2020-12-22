package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.project.Project;
import com.hoondragonite.aboutme.dto.PjtSaveRequestDto;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.PjtRepository;
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
public class PjtService {
    @PersistenceContext
    EntityManager em;

    private final PjtRepository pjtRepository;

    @Transactional
    public List<Project> findAllByuID(Long uID){
        return  pjtRepository.findAllByuID(uID);
    }

    @Transactional
    public Optional<Project> findByuID(Long uID){
        return pjtRepository.findByuID(uID);
    }

    //Test에서 사용
    @Transactional
    public Long savePjt(Long uID, PjtSaveRequestDto dto){
        pushPjt(uID, dto);
        return uID;
    }

    @Transactional
    public Long savePjtList(Long uID, List<PjtSaveRequestDto> dtoList){
        PjtSaveRequestDto dto;
        for(int i=0; i<dtoList.size(); i++){
            dto = dtoList.get(i);
            if(dto.getPjtName().equals("")){
                continue;
            }
            pushPjt(uID, dto);
        }

        return uID;
    }

    private void pushPjt(Long uID, PjtSaveRequestDto dto) {
        if(dto.getPjtSeq() == null){
            Project newEntity = dto.toEntity();
            newEntity.setUID(uID);
            pjtRepository.save(newEntity);
        }
        else{
            Optional<Project> optionalProject =pjtRepository.findById(dto.getPjtSeq());
            if(optionalProject.isPresent()){
                Project updateEntity = optionalProject.get();
                System.out.println("updateEntity getUID:" + updateEntity.getUID());
                updateEntity.updateProject(dto.getPjtName(),dto.getPjtTeam(),dto.getPjtStartDate(),dto.getPjtEndDate(),dto.getPjtDesc(),dto.getPjtTechStack(),dto.getPjtMainTech(),dto.getPjtRole());
                System.out.println("updateEntity getUID:" + updateEntity.getUID());
                pjtRepository.save(updateEntity);
            }
        }
    }
}
