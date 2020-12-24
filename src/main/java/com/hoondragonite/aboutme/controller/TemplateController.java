package com.hoondragonite.aboutme.controller;

import com.hoondragonite.aboutme.domain.template.Template;
import com.hoondragonite.aboutme.repository.TemplateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class TemplateController {
    private final TemplateRepository templateRepository;
    @RequestMapping(value="/template")
    public String template(Model model){
        List<Template> templateList = templateRepository.findAll();
        if(templateList.size() > 0) {
            model.addAttribute(templateList);
        }
        return "template";
    }
}
