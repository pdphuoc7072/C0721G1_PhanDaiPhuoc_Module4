package com.codegym.controller;

import com.codegym.model.MedicalDeclaration;
import com.codegym.service.IMedicalDeclarationService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public String save (@ModelAttribute MedicalDeclaration medicalDeclaration, Model model) {
        medicalDeclaration.setIdForm((int) (Math.random()*10000));
        medicalDeclarationService.save(medicalDeclaration);
        model.addAttribute("medicalDeclaration", medicalDeclaration);
        return "info";
    }

    @GetMapping ("/{idForm}/edit")
    public String edit (@PathVariable int idForm, Model model) {
        model.addAttribute("medicalDeclaration", medicalDeclarationService.findById(idForm));
        model.addAttribute("genderArray", new String[] {"Male", "Female", "Other"});
        model.addAttribute("travelInfoArray", new String[]{"Airplane", "Ships", "Car", "Other"});
        model.addAttribute("booleanArray", new Boolean[] {true, false});
        return "edit";
    }

    @PostMapping ("/update")
    public String update (MedicalDeclaration medicalDeclaration, Model model) {
        medicalDeclarationService.update(medicalDeclaration.getIdForm(), medicalDeclaration);
        model.addAttribute("message", "Form was successful updated");
        return "info";
    }
}
