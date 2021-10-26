package com.codegym.controller;

import com.codegym.model.EmailSettings;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/email-settings")
public class EmailSettingsController {

    @GetMapping ("")
    public ModelAndView showFormEmailSettings () {
        ModelAndView modelAndView = new ModelAndView("email-settings");
        modelAndView.addObject("emailSettings", new EmailSettings());
        modelAndView.addObject("languagesArray", new String[] {"English", "Vietnamese", "Japanese", "Chinese"});
        modelAndView.addObject("pageSizeArray", new int[] {5, 10, 15, 25, 50, 100});
        return modelAndView;
    }

    @PostMapping ("/update")
    public ModelAndView update (@ModelAttribute ("emailSettings") EmailSettings emailSettings) {
        ModelAndView modelAndView = new ModelAndView("info");
        modelAndView.addObject("emailSettings", emailSettings);
        return modelAndView;
    }
}
