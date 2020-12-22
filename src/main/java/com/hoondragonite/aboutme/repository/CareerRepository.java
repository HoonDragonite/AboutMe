package com.hoondragonite.aboutme.repository;

import com.hoondragonite.aboutme.domain.career.Career;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CareerRepository extends JpaRepository<Career, Long> {
    Optional<Career> findByuID(Long uID);
    List<Career> findAllByuID(Long uID);
}
