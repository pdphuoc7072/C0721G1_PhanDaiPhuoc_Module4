package com.codegym.controller;

import com.codegym.model.ImageOfTheDay;
import com.codegym.service.IImageOfTheDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/home")
public class ImageOfTheDayController {
    @Autowired
    private IImageOfTheDayService iImageOfTheDayService;

    @GetMapping("")
    public ModelAndView home () {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("imageOfTheDay", new ImageOfTheDay((short) 4, "Phuoc", "Codegym raising the bar"));
        List<ImageOfTheDay> imageOfTheDayList = iImageOfTheDayService.findAll();
        modelAndView.addObject("imageOfTheDayList", imageOfTheDayList);
        return modelAndView;
    }

    @PostMapping
    public String save (ImageOfTheDay imageOfTheDay) {
        iImageOfTheDayService.saveOrUpdate(imageOfTheDay);
        return "redirect:/home";
    }

    @PostMapping(value = "/like/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<ImageOfTheDay> like (@PathVariable(name = "id")Long id) {
        ImageOfTheDay imageOfTheDay = iImageOfTheDayService.like(id);
        System.out.println(imageOfTheDay.getLikeCount());
        if (imageOfTheDay == null) {
            return new ResponseEntity<>(imageOfTheDay, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(imageOfTheDay, HttpStatus.OK);
    }
}
