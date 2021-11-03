package com.codegym.controller;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.service.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/education-degree")
public class EducationDegreeController {
    @Autowired
    private IEducationDegreeService educationDegreeService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("education_degree/list");
        modelAndView.addObject("educationDegrees", educationDegreeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("education_degree/create");
        modelAndView.addObject("educationDegree", new EducationDegree());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute EducationDegree educationDegree) {
        educationDegreeService.save(educationDegree);
        return "redirect:/education-degree";
    }
}
