package com.codegym.controller;

import com.codegym.dto.ContractDetailDto;
import com.codegym.model.AttachService;
import com.codegym.model.Contract;
import com.codegym.model.ContractDetail;
import com.codegym.service.IAttachServiceService;
import com.codegym.service.IContractDetailService;
import com.codegym.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/contract-detail")
public class ContractDetailController {
    @Autowired
    private IContractDetailService contractDetailService;

    @Autowired
    private IAttachServiceService attachServiceService;

    @Autowired
    private IContractService contractService;

    @ModelAttribute("attachServices")
    private Iterable<AttachService> attachServices () {
        return attachServiceService.findAll();
    }

    @ModelAttribute("contracts")
    private Iterable<Contract> contracts () {
        return contractService.findAll();
    }

    @GetMapping("")
    private ModelAndView list () {
        ModelAndView modelAndView = new ModelAndView("contract_detail/list");
        modelAndView.addObject("contractDetails", contractDetailService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("contract_detail/create");
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute ContractDetailDto contractDetailDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "contract_detail/create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            return "redirect:/contract-detail";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<ContractDetail> contractDetail = contractDetailService.findById(id);
        ContractDetailDto contractDetailDto = new ContractDetailDto();
        BeanUtils.copyProperties(contractDetail.get(), contractDetailDto);
        ModelAndView modelAndView;
        if (contractDetailDto != null) {
            modelAndView = new ModelAndView("/contract_detail/edit");
            modelAndView.addObject("contractDetailDto", contractDetailDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (@Valid @ModelAttribute("contractDetailDto") ContractDetailDto contractDetailDto, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return "contract_detail/edit";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            contractDetailService.save(contractDetail);
            return "redirect:/contract-detail";
        }
    }

    @PostMapping("/delete")
    public String delete (@RequestParam Long idContractDetail) {
        contractDetailService.remove(idContractDetail);
        return "redirect:/contract-detail";
    }
}
