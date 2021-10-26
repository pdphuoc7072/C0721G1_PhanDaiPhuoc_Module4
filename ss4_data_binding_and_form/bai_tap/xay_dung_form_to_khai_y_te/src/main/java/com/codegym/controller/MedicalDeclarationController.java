package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/medical-declaration")
public class MedicalDeclarationController {
    @Autowired
    private IMedicalDeclarationService medicalDeclarationService;

    @GetMapping ("")
    public ModelAndView showForm () {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("medicalDeclaration", new MedicalDeclaration());
        modelAndView.addObject("genderArray", new String[] {"Male", "Female", "Other"});
        modelAndView.addObject("travelInfoArray", new String[]{"Airplane", "Ships", "Car", "Other"});
        modelAndView.addObject("booleanArray", new Boolean[] {true, false});
        return modelAndView;
    }

    @PostMapping ("/save")
    public String save (@ModelAttribute ("medicalDeclaration") MedicalDeclaration medicalDeclaration, Model model) {
        medicalDeclarationService.save(medicalDeclaration);
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        return "info";
    }

    @PostMapping ("/update")
    public String update (@ModelAttribute ("medicalDeclaration") MedicalDeclaration medicalDeclaration, Model model) {
        model.addAttribute("genderArray", new String[] {"Male", "Female", "Other"});
        model.addAttribute("travelInfoArray", new String[]{"Airplane", "Ships", "Car", "Other"});
        model.addAttribute("booleanArray", new Boolean[] {true, false});
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        return "index";
    }
}
