package com.codegym.controller;

import com.codegym.model.Smartphone;
import com.codegym.service.impl.SmartphoneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/smartphones")
public class SmartphoneController {

    @Autowired
    private SmartphoneServiceImpl smartphoneServiceImpl;

    @GetMapping("")
    public ModelAndView getSmartPhone() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Smartphone> smartphones = smartphoneServiceImpl.findAll();
        modelAndView.addObject("smartphones", smartphones);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createSmartphoneForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("smartphone", new Smartphone());
        return modelAndView;
    }

    @PostMapping(value = "create", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone createSmartphone(@RequestBody Smartphone smartphone) {
        return smartphoneServiceImpl.save(smartphone);
    }

    @GetMapping("{id}/edit")
    public ModelAndView editSmartphoneForm(@PathVariable("id") Integer id)  {
        Optional<Smartphone> smartphone = smartphoneServiceImpl.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("smartphone", smartphone.get());
        return modelAndView;
    }

    @PostMapping(value = "{id}/edit", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Smartphone editSmartphone(@PathVariable("id") Integer id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        return smartphoneServiceImpl.save(smartphone);
    }

    @PostMapping(value = "{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteSmartphone(@PathVariable Integer id) {
        smartphoneServiceImpl.remove(id);
    }
}