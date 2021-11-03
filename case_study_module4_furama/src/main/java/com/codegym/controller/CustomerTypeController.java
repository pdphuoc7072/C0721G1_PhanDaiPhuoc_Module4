package com.codegym.controller;

import com.codegym.model.CustomerType;
import com.codegym.model.EducationDegree;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer-type")
public class CustomerTypeController {
    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("customer_type/list");
        modelAndView.addObject("customerTypes", customerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("customer_type/create");
        modelAndView.addObject("customerType", new CustomerType());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute CustomerType customerType) {
        customerTypeService.save(customerType);
        return "redirect:/customer-type";
    }
}
