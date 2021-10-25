package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class TimeZoneController {

    @GetMapping (value = "/world-clock")
    public String getTimeByTimeZone (@RequestParam (name = "city", required = false, defaultValue = "Asia/Ho_Chi_Minh") String city, Model model) {
        Date date = new Date();
        TimeZone timeZone = TimeZone.getDefault();
        TimeZone localTimeZone = TimeZone.getTimeZone(city);
        Long localTime = date.getTime() + (localTimeZone.getRawOffset() - timeZone.getRawOffset());
        date.setTime(localTime);
        model.addAttribute("city", city);
        model.addAttribute("date", date);
        return "/world-clock";
    }
}
