package com.hoondragonite.aboutme.repository;

import com.hoondragonite.aboutme.domain.project.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PjtRepository extends JpaRepository<Project, Long> {
    Optional<Project> findByuID(Long uID);
    List<Project> findAllByuID(Long uID);
    
}
