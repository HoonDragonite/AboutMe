package com.hoondragonite.aboutme.repository;

import com.hoondragonite.aboutme.domain.template.Template;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<Template, Long> {
}
