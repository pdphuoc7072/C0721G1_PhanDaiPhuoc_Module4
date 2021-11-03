package com.codegym.controller;

import com.codegym.model.Position;
import com.codegym.model.RentType;
import com.codegym.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rent-type")
public class RentTypeController {
    @Autowired
    private IRentTypeService rentTypeService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("rent_type/list");
        modelAndView.addObject("rentTypes", rentTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("rent_type/create");
        modelAndView.addObject("rentType", new RentType());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute RentType rentType) {
        rentTypeService.save(rentType);
        return "redirect:/rent-type";
    }
}
