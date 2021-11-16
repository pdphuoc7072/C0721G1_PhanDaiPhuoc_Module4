package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.*;
import com.codegym.service.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPositionService positionService;

    @Autowired
    private IEducationDegreeService educationDegreeService;

    @Autowired
    private IDivisionService divisionService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @ModelAttribute("positions")
    public Iterable<Position> positions() {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees() {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public Iterable<Division> divisions() {
        return divisionService.findAll();
    }

    @GetMapping("/admin/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/admin/save")
    public String save(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
        List<Role> roles = roleService.findAll();
        User user = userService.findByUsername(employeeDto.getUser().getUsername());
        employeeDto.getUser().setUserId(user.getUserId());
        if (employeeDto.getPosition().getPositionId() == 5 || employeeDto.getPosition().getPositionId() == 6) {
            for (Role role : roles) {
                userService.insertUserRole(employeeDto.getUser().getUserId(), role.getRoleId());
            }
        } else {
            for (Role role : roles) {
                if (role.getRoleId() == 2) {
                    userService.insertUserRole(employeeDto.getUser().getUserId(), role.getRoleId());
                }
            }
        }
        boolean checkIdCard = true;
        boolean checkPhone = true;
        boolean checkEmail = true;
        employeeDto.setEmployees(employeeService.findAll());
        employeeDto.setCheckIdCard(checkIdCard);
        employeeDto.setCheckPhone(checkPhone);
        employeeDto.setCheckEmail(checkEmail);
        employeeDto.validate(employeeDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "employee/create";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "employeeName", defaultValue = "", required = false) String employeeName,
                             @RequestParam(value = "employeePhone", defaultValue = "", required = false) String employeePhone,
                             @RequestParam(value = "positionId", defaultValue = "", required = false) String positionId,
                             @PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable, employeeName, employeePhone, positionId);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("employeeName", employeeName);
        modelAndView.addObject("employeePhone", employeePhone);
        modelAndView.addObject("positionId", positionId);
        return modelAndView;
    }

    @GetMapping("/admin/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee.get(), employeeDto);
        ModelAndView modelAndView;
        if (employeeDto != null) {
            modelAndView = new ModelAndView("/employee/edit");
            modelAndView.addObject("employeeDto", employeeDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/admin/update")
    public String update(@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
        List<Employee> employees = employeeService.findAll();
        Optional<Employee> employeeOptional = employeeService.findById(employeeDto.getEmployeeId());
        employeeDto.setUser(employeeOptional.get().getUser());

        String oldIdCard = employeeOptional.get().getEmployeeIdCard();
        String oldPhone = employeeOptional.get().getEmployeePhone();
        String oldEmail = employeeOptional.get().getEmployeeEmail();
        boolean checkIdCard = false;
        boolean checkPhone = false;
        boolean checkEmail = false;

        if (!oldPhone.equals(employeeDto.getEmployeePhone())) {
            checkPhone = true;
            employeeDto.setEmployees(employees);
            employeeDto.setCheckIdCard(checkIdCard);
            employeeDto.setCheckEmail(checkEmail);
            employeeDto.setCheckPhone(checkPhone);
            employeeDto.validate(employeeDto, bindingResult);
            checkPhone = false;
        }
        if (!oldEmail.equals(employeeDto.getEmployeeEmail())) {
            checkEmail = true;
            employeeDto.setEmployees(employees);
            employeeDto.setCheckIdCard(checkIdCard);
            employeeDto.setCheckEmail(checkEmail);
            employeeDto.setCheckPhone(checkPhone);
            employeeDto.validate(employeeDto, bindingResult);
            checkEmail = false;
        }
        if (!oldIdCard.equals(employeeDto.getEmployeeIdCard())) {
            checkIdCard = true;
            employeeDto.setEmployees(employees);
            employeeDto.setCheckIdCard(checkIdCard);
            employeeDto.setCheckEmail(checkEmail);
            employeeDto.setCheckPhone(checkPhone);
            employeeDto.validate(employeeDto, bindingResult);
            checkIdCard = false;
        }

        if (bindingResult.hasFieldErrors()) {
            return "employee/edit";
        } else {
            Employee employee = new Employee();
            BeanUtils.copyProperties(employeeDto, employee);
            employeeService.save(employee);
            return "redirect:/employee";
        }
    }

    @PostMapping("/admin/delete")
    public String delete(@RequestParam Long idEmployee) {
        employeeService.remove(idEmployee);
        return "redirect:/employee";
    }

    @PostMapping("/admin/deleteMultiple")
    public String deleteMultiple(@RequestParam String idEmployeeMultiple) {
        String[] idEmployeeMultipleArray = idEmployeeMultiple.split(",");
        for (int i = 0; i < idEmployeeMultipleArray.length; i++) {
            employeeService.remove(Long.valueOf(idEmployeeMultipleArray[i]));
        }
        return "redirect:/employee";
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<Employee> employee = employeeService.findById(id);
        return new ResponseEntity<>(employee.get(), HttpStatus.OK);
    }
}
