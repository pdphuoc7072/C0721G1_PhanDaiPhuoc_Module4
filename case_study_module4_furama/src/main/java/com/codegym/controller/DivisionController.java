package com.codegym.controller;

import com.codegym.model.Division;
import com.codegym.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/division")
public class DivisionController {
    @Autowired
    private IDivisionService divisionService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("division/list");
        modelAndView.addObject("divisions", divisionService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("division/create");
        modelAndView.addObject("division", new Division());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute Division division) {
        divisionService.save(division);
        return "redirect:/division";
    }
}
