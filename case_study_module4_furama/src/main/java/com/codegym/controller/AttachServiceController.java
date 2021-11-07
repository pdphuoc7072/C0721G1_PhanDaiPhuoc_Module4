package com.codegym.controller;

import com.codegym.dto.AttachServiceDto;
import com.codegym.model.AttachService;
import com.codegym.service.IAttachServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/attach-service")
public class AttachServiceController {
    @Autowired
    private IAttachServiceService attachServiceService;

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("attach_service/list");
        modelAndView.addObject("attachServices", attachServiceService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("attach_service/create");
        modelAndView.addObject("attachServiceDto", new AttachServiceDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute AttachServiceDto attachServiceDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "attach_service/create";
        } else {
            AttachService attachService = new AttachService();
            BeanUtils.copyProperties(attachServiceDto, attachService);
            attachServiceService.save(attachService);
            return "redirect:/attach-service";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<AttachService> attachService = attachServiceService.findById(id);
        AttachServiceDto attachServiceDto = new AttachServiceDto();
        BeanUtils.copyProperties(attachService.get(), attachServiceDto);
        ModelAndView modelAndView;
        if (attachServiceDto != null) {
            modelAndView = new ModelAndView("/attach_service/edit");
            modelAndView.addObject("attachServiceDto", attachServiceDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (@Valid @ModelAttribute("attachServiceDto") AttachServiceDto attachServiceDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "attach_service/edit";
        } else {
            AttachService attachService = new AttachService();
            BeanUtils.copyProperties(attachServiceDto, attachService);
            attachServiceService.save(attachService);
            return "redirect:/attach-service";
        }
    }

    @PostMapping("/delete")
    public String delete (@RequestParam Long idAttachService) {
        attachServiceService.remove(idAttachService);
        return "redirect:/attach-service";
    }
}
