package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping (value = "/sandwich")
public class SandwichController {
    @GetMapping (value = "/")
    public String sandwich () {
        return "/save";
    }
    @PostMapping("/save")
    public String save (@RequestParam("sandwichCheckbox") String[] sandwichCheckbox, Model model) {
        model.addAttribute("sandwichCheckbox", sandwichCheckbox);
        return "/save";
    }
}
