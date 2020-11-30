package com.hoondragonite.aboutme.service;

import com.hoondragonite.aboutme.domain.project.Project;
import com.hoondragonite.aboutme.dto.PjtSaveRequestDto;
import com.hoondragonite.aboutme.dto.UserInfoSaveRequestDto;
import com.hoondragonite.aboutme.repository.PjtRepository;
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

    @Transactional
    public Long savePjt(Long uID, PjtSaveRequestDto dto){
        if(dto.getPjtSeq() == null){
            Project newEntity = dto.toEntity();
            newEntity.setUID(uID);
            pjtRepository.save(newEntity);
        }
        else{
            Optional<Project> finded =pjtRepository.findById(dto.getPjtSeq());
            if(finded.isPresent()){
                Project updateEntity = finded.get();
                updateEntity.updateProject(dto.getUID(),dto.getPjtName(),dto.getPjtTeam(),dto.getPjtStartDate(),dto.getPjtEndDate(),dto.getPjtDesc(),dto.getPjtTechStack(),dto.getPjtMainTech(),dto.getPjtRole());
                pjtRepository.save(updateEntity);
            }
        }
        return uID;
    }
}
