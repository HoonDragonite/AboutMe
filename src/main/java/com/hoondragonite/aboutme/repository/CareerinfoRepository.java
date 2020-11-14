package com.hoondragonite.aboutme.repository;

import com.hoondragonite.aboutme.domain.careerinfo.Careerinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerinfoRepository extends JpaRepository<Careerinfo, Long> {
}
