package com.codegym.controller;

import com.codegym.dto.GroundDto;
import com.codegym.model.Ground;
import com.codegym.model.GroundType;
import com.codegym.model.Status;
import com.codegym.service.IGroundService;
import com.codegym.service.IGroundTypeService;
import com.codegym.service.IStatusService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ground")
public class GroundController {
    @Autowired
    private IGroundService groundService;

    @Autowired
    private IStatusService statusService;

    @Autowired
    private IGroundTypeService groundTypeService;

    @ModelAttribute("statuses")
    public List<Status> statuses () {
        return statusService.findAll();
    }

    @ModelAttribute("groundTypes")
    public List<GroundType> groundTypes () {
        return groundTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("ground/create");
        modelAndView.addObject("groundDto", new GroundDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("groundDto") GroundDto groundDto, BindingResult bindingResult) {
        boolean checkCode = true;
        boolean checkDate = true;
        groundDto.setGrounds(groundService.findAll());
        groundDto.setCheckCode(checkCode);
        groundDto.setCheckDate(checkDate);
        groundDto.validate(groundDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "ground/create";
        } else {
            Ground ground = new Ground();
            BeanUtils.copyProperties(groundDto, ground);
            groundService.save(ground);
            return "redirect:/ground";
        }
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "floor", defaultValue = "", required = false) String floor,
                             @RequestParam(value = "money", defaultValue = "", required = false) String money,
                             @RequestParam(value = "groundTypeId", defaultValue = "", required = false) String groundTypeId,
                             @PageableDefault(size = 5, sort = "area", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Ground> grounds = groundService.findAll(pageable, floor, money, groundTypeId);
        ModelAndView modelAndView = new ModelAndView("ground/list");
        modelAndView.addObject("grounds", grounds);
        modelAndView.addObject("floor", floor);
        modelAndView.addObject("money", money);
        modelAndView.addObject("groundTypeId", groundTypeId);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Ground> ground = groundService.findById(id);
        GroundDto groundDto = new GroundDto();
        BeanUtils.copyProperties(ground.get(), groundDto);
        ModelAndView modelAndView;
        if (groundDto != null) {
            modelAndView = new ModelAndView("/ground/edit");
            modelAndView.addObject("groundDto", groundDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("groundDto") GroundDto groundDto, BindingResult bindingResult) {
        List<Ground> grounds = groundService.findAll();
        Optional<Ground> groundOptional = groundService.findById(groundDto.getId());
        String oldCode = groundOptional.get().getCode();
        boolean checkCode = false;
        boolean checkDate = true;

        if (!oldCode.equals(groundDto.getCode())) {
            checkCode = true;
            groundDto.setGrounds(grounds);
            groundDto.setCheckCode(checkCode);
            groundDto.validate(groundDto, bindingResult);
            checkCode = false;
        }

        if (checkDate) {
            groundDto.setGrounds(grounds);
            groundDto.setCheckCode(checkCode);
            groundDto.setCheckDate(checkDate);
            groundDto.validate(groundDto, bindingResult);
        }

        if (bindingResult.hasFieldErrors()) {
            return "ground/edit";
        } else {
            Ground ground = new Ground();
            BeanUtils.copyProperties(groundDto, ground);
            groundService.save(ground);
            return "redirect:/ground";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long idGround) {
        groundService.remove(idGround);
        return "redirect:/ground";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiple(@RequestParam String idGroundMultiple) {
        String[] idGroundMultipleArray = idGroundMultiple.split(",");
        for (int i = 0; i < idGroundMultipleArray.length; i++) {
            groundService.remove(Long.valueOf(idGroundMultipleArray[i]));
        }
        return "redirect:/ground";
    }
}
