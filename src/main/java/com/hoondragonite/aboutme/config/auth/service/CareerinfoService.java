package com.hoondragonite.aboutme.config.auth.service;

import com.hoondragonite.aboutme.config.auth.dto.CareerinfoDto;
import com.hoondragonite.aboutme.domain.careerinfo.Careerinfo;
import com.hoondragonite.aboutme.repository.CareerinfoRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class CareerinfoService {
    private CareerinfoRepository careerinfoRepository;

    public CareerinfoService(CareerinfoRepository careerinfoRepository){
        this.careerinfoRepository = careerinfoRepository;
    }

    @Transactional
    public Long saveCareer(Careerinfo careerinfo){
        return careerinfoRepository.save(careerinfo).getCno();
    }

    @Transactional
    public List<CareerinfoDto> getCareerList(){
        List<Careerinfo> clist = careerinfoRepository.findAll();
        List<CareerinfoDto> cdtolist = new ArrayList<>();

        for(Careerinfo ca : clist){
            Careerinfo cd = Careerinfo.builder()
                    .cno(ca.getCno())
                    .cicarname(ca.getCicarname())
                    .cicomment(ca.getCicomment())
                    .startdate(ca.getStartdate())
                    .enddate(ca.getEnddate())
                    .build();

            cdtolist.add(cd);
        }

        return cdtolist;
    }

    public Long modifyCareer(Careerinfo careerinfo){
        return careerinfoRepository.save(careerinfo).getCno();
    }

    @Transactional
    public void deleteCareer(Long cno){
        careerinfoRepository.deleteById(cno);
    }


}
