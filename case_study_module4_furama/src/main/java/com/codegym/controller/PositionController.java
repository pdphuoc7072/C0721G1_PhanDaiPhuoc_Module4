package com.codegym.controller;

import com.codegym.model.Position;
import com.codegym.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private IPositionService positionService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("position/list");
        modelAndView.addObject("positions", positionService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("position/create");
        modelAndView.addObject("position", new Position());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute Position position) {
        positionService.save(position);
        return "redirect:/position";
    }
}
