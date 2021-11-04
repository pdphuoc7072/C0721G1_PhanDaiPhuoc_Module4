package com.codegym.controller;

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
//        modelAndView.addObject("employeeDto", new EmployeeDto());
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("customer") Customer customer) {
//        employeeDto.getUser().setPassword("123456");
//        EmployeeDto employeeDtoTemp = new EmployeeDto();
//        employeeDtoTemp.setEmployees(employeeService.findAll());
//        employeeDtoTemp.validate(employeeDto, bindingResult);
//        if (bindingResult.hasFieldErrors()) {
//            return "employee/create";
//        } else {
//            Employee employee = new Employee();
//            BeanUtils.copyProperties(employeeDto, employee);
//            employeeService.save(employee);
//            return "redirect:/employee";
//        }
        customerService.save(customer);
        return "redirect:/customer";
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
}
