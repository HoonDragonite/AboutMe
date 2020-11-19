package com.hoondragonite.aboutme.config.auth.service;

import com.hoondragonite.aboutme.config.auth.dto.CareerinfoDto;
import com.hoondragonite.aboutme.domain.careerinfo.Careerinfo;
import com.hoondragonite.aboutme.repository.CareerinfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

//@RequiredArgsConstructor
@Service
public class CareerinfoService {
    private CareerinfoRepository careerinfoRepository;

    public CareerinfoService(CareerinfoRepository careerinfoRepository){
        this.careerinfoRepository = careerinfoRepository;
    }

    @Transactional
    public Long saveCareer(CareerinfoDto CareerinfoDto){
        return careerinfoRepository.save(CareerinfoDto.toEntity()).getCno();
    }

    @Transactional
    public List<CareerinfoDto> getCareerList(){
        List<Careerinfo> clist = careerinfoRepository.findAll();
        List<CareerinfoDto> cdtolist = new ArrayList<>();
        return cdtolist;
    }

//    public void deleteCareer(Long cno){
//        careerinfoRepository.deleteById(cno);
//    }



}
