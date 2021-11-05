package com.codegym.controller;

import com.codegym.dto.CustomerDto;
import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.service.ICustomerService;
import com.codegym.service.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @ModelAttribute("customerTypes")
    public Iterable<CustomerType> customerTypes () {
        return customerTypeService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        boolean checkCode = true;
        boolean checkIdCard = true;
        boolean checkPhone = true;
        boolean checkEmail = true;
        customerDto.setCustomers(customerService.findAll());
        customerDto.setCheckCode(checkCode);
        customerDto.setCheckIdCard(checkIdCard);
        customerDto.setCheckPhone(checkPhone);
        customerDto.setCheckEmail(checkEmail);
        customerDto.validate(customerDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "customer/create";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer";
        }
    }

    @GetMapping("")
    public ModelAndView list (@RequestParam(value = "customerName", defaultValue = "", required = false) String customerName,
                              @RequestParam (value = "customerPhone", defaultValue = "", required = false) String customerPhone,
                              @RequestParam (value = "customerTypeId", defaultValue = "", required = false) String customerTypeId,
                              @PageableDefault(size = 3) Pageable pageable) {
        Page<Customer> customers = customerService.findAll(pageable, customerName, customerPhone, customerTypeId);
        ModelAndView modelAndView = new ModelAndView("/customer/list");
        modelAndView.addObject("customers", customers);
        modelAndView.addObject("customerName", customerName);
        modelAndView.addObject("customerPhone", customerPhone);
        modelAndView.addObject("customerTypeId", customerTypeId);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Customer> customer = customerService.findById(id);
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer.get(), customerDto);
        ModelAndView modelAndView;
        if (customerDto != null) {
            modelAndView = new ModelAndView("/customer/edit");
            modelAndView.addObject("customerDto", customerDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update (@Valid @ModelAttribute("customerDto") CustomerDto customerDto, BindingResult bindingResult) {
        Optional<Customer> customerOptional = customerService.findById(customerDto.getCustomerId());
        String oldCode = customerOptional.get().getCustomerCode();
        String oldIdCard = customerOptional.get().getCustomerIdCard();
        String oldPhone = customerOptional.get().getCustomerPhone();
        String oldEmail = customerOptional.get().getCustomerEmail();
        boolean checkCode = false;
        boolean checkIdCard = false;
        boolean checkPhone = false;
        boolean checkEmail = false;
        if (!oldCode.equals(customerDto.getCustomerCode())) {
            checkCode = true;
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(checkCode);
            customerDto.setCheckIdCard(checkIdCard);
            customerDto.setCheckPhone(checkPhone);
            customerDto.setCheckEmail(checkEmail);
            customerDto.validate(customerDto, bindingResult);
            checkCode = false;
        }
        if (!oldIdCard.equals(customerDto.getCustomerIdCard())) {
            checkIdCard = true;
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(checkCode);
            customerDto.setCheckIdCard(checkIdCard);
            customerDto.setCheckPhone(checkPhone);
            customerDto.setCheckEmail(checkEmail);
            customerDto.validate(customerDto, bindingResult);
            checkIdCard = false;
        }
        if (!oldPhone.equals(customerDto.getCustomerPhone())) {
            checkPhone = true;
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(checkCode);
            customerDto.setCheckIdCard(checkIdCard);
            customerDto.setCheckPhone(checkPhone);
            customerDto.setCheckEmail(checkEmail);
            customerDto.validate(customerDto, bindingResult);
            checkPhone = false;
        }
        if (!oldEmail.equals(customerDto.getCustomerEmail())) {
            checkEmail = true;
            customerDto.setCustomers(customerService.findAll());
            customerDto.setCheckCode(checkCode);
            customerDto.setCheckIdCard(checkIdCard);
            customerDto.setCheckPhone(checkPhone);
            customerDto.setCheckEmail(checkEmail);
            customerDto.validate(customerDto, bindingResult);
            checkEmail = false;
        }

        if (bindingResult.hasFieldErrors()) {
            return "customer/edit";
        } else {
            Customer customer = new Customer();
            BeanUtils.copyProperties(customerDto, customer);
            customerService.save(customer);
            return "redirect:/customer";
        }
    }

    @PostMapping("/delete")
    public String delete (@RequestParam Long idCustomer) {
        customerService.remove(idCustomer);
        return "redirect:/customer";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiple (@RequestParam String idCustomerMultiple) {
        String[] idCustomerMultipleArray = idCustomerMultiple.split(",");
        for (int i = 0; i < idCustomerMultipleArray.length; i++) {
            customerService.remove(Long.valueOf(idCustomerMultipleArray[i]));
        }
        return "redirect:/customer";
    }
}
