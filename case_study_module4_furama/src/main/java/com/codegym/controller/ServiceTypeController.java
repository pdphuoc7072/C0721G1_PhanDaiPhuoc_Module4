package com.codegym.controller;

import com.codegym.model.Division;
import com.codegym.model.ServiceType;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service-type")
public class ServiceTypeController {
    @Autowired
    private IServiceTypeService serviceTypeService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("service_type/list");
        modelAndView.addObject("serviceTypes", serviceTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("service_type/create");
        modelAndView.addObject("serviceType", new ServiceType());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute ServiceType serviceType) {
        serviceTypeService.save(serviceType);
        return "redirect:/service-type";
    }
}
