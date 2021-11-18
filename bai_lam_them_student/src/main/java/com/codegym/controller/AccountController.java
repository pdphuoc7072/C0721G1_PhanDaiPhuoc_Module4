package com.codegym.controller;

import com.codegym.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView("account/list");
        modelAndView.addObject("accounts", accountService.findByFlag(true));
        return modelAndView;
    }
}
