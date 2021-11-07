package com.codegym.controller;

import com.codegym.dto.ServiceDto;
import com.codegym.model.RentType;
import com.codegym.model.Service;
import com.codegym.model.ServiceType;
import com.codegym.service.IRentTypeService;
import com.codegym.service.IServiceService;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private IServiceService serviceService;

    @Autowired
    private IServiceTypeService serviceTypeService;

    @Autowired
    private IRentTypeService rentTypeService;

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes () {
        return serviceTypeService.findAll();
    }

    @ModelAttribute("rentTypes")
    public Iterable<RentType> rentTypes () {
        return rentTypeService.findAll();
    }

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("services", serviceService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("serviceDto", new ServiceDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute ServiceDto serviceDto, BindingResult bindingResult) {
        boolean checkCode = true;
        serviceDto.setServices(serviceService.findAll());
        serviceDto.setCheckCode(checkCode);
        serviceDto.validate(serviceDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "service/create";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            return "redirect:/service";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Service> service = serviceService.findById(id);
        ServiceDto serviceDto = new ServiceDto();
        BeanUtils.copyProperties(service.get(), serviceDto);
        ModelAndView modelAndView;
        if (serviceDto != null) {
            modelAndView = new ModelAndView("/service/edit");
            modelAndView.addObject("serviceDto", serviceDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (@Valid @ModelAttribute("serviceDto") ServiceDto serviceDto, BindingResult bindingResult) {
        Optional<Service> serviceOptional = serviceService.findById(serviceDto.getServiceId());
        String oldCode = serviceOptional.get().getServiceCode();
        boolean checkCode = false;
        if (!oldCode.equals(serviceDto.getServiceCode())) {
            checkCode = true;
            serviceDto.setServices(serviceService.findAll());
            serviceDto.setCheckCode(checkCode);
            serviceDto.validate(serviceDto, bindingResult);
        }
        if (bindingResult.hasFieldErrors()) {
            return "service/edit";
        } else {
            Service service = new Service();
            BeanUtils.copyProperties(serviceDto, service);
            serviceService.save(service);
            return "redirect:/service";
        }
    }

    @PostMapping("/delete")
    public String delete (@RequestParam Long idService) {
        serviceService.remove(idService);
        return "redirect:/service";
    }
}
