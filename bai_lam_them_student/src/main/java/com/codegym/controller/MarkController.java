package com.codegym.controller;

import com.codegym.model.Mark;
import com.codegym.model.Student;
import com.codegym.model.Subject;
import com.codegym.service.IMarkService;
import com.codegym.service.IStudentService;
import com.codegym.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/mark")
public class MarkController {
    @Autowired
    private IMarkService markService;

    @Autowired
    private ISubjectService subjectService;

    @Autowired
    private IStudentService studentService;

    @ModelAttribute("subjects")
    public List<Subject> subjects () {
        return subjectService.findAll();
    }

    @ModelAttribute("students")
    public List<Student> students () {
        return studentService.findAll();
    }

    @GetMapping("")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView("mark/list");
        modelAndView.addObject("marks", markService.findByFlag(true));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("mark/create");
        modelAndView.addObject("mark", new Mark());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("mark") Mark mark) {
        mark.setFlag(true);
        markService.save(mark);
        return "redirect:/mark";
    }
}
