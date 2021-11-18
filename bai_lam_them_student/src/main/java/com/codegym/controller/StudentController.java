package com.codegym.controller;

import com.codegym.model.*;
import com.codegym.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private IClassesService classesService;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IMarkService markService;

    @ModelAttribute("classes")
    private List<Classes> classes () {
        return classesService.findAll();
    }

    @GetMapping("")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView("student/list");
        modelAndView.addObject("students", studentService.findByFlag(true));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("student/create");
        modelAndView.addObject("student", new Student());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("student") Student student) {
        Account account = accountService.findByUsername(student.getAccount().getUsername());
        student.getAccount().setId(account.getId());
        student.setFlag(true);
        account.setFlag(true);
        studentService.save(student);
        return "redirect:/student";
    }

    @PostMapping("/delete")
    public String delete (@RequestParam Long idStudent) {
        Optional<Student> student = studentService.findById(idStudent);
        Optional<Account> account = accountService.findById(student.get().getAccount().getId());
        List<Mark> marks = markService.findByStudentId(idStudent);
        student.get().setFlag(false);
        studentService.save(student.get());
        account.get().setFlag(false);
        accountService.save(account.get());
        for (Mark mark : marks) {
            mark.setFlag(false);
            markService.save(mark);
        }
        return "redirect:/student";
    }
}
