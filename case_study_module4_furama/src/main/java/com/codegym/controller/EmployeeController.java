package com.codegym.controller;

import com.codegym.dto.EmployeeDto;
import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Employee;
import com.codegym.model.Position;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationDegreeService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
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

    @ModelAttribute("positions")
    public Iterable<Position> positions () {
        return positionService.findAll();
    }

    @ModelAttribute("educationDegrees")
    public Iterable<EducationDegree> educationDegrees () {
        return educationDegreeService.findAll();
    }

    @ModelAttribute("divisions")
    public Iterable<Division> divisions () {
        return divisionService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
        employeeDto.getUser().setPassword("123456");
        EmployeeDto employeeDtoTemp = new EmployeeDto();
        employeeDtoTemp.setEmployees(employeeService.findAll());
        employeeDtoTemp.validate(employeeDto, bindingResult);
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
    public ModelAndView list (@RequestParam(value = "employeeName", defaultValue = "", required = false) String employeeName,
                              @RequestParam (value = "employeePhone", defaultValue = "", required = false) String employeePhone,
                              @RequestParam (value = "positionId", defaultValue = "", required = false) String positionId,
                              @PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employees = employeeService.findAll(pageable, employeeName, employeePhone, positionId);
        ModelAndView modelAndView = new ModelAndView("/employee/list");
        modelAndView.addObject("employees", employees);
        modelAndView.addObject("employeeName", employeeName);
        modelAndView.addObject("employeePhone", employeePhone);
        modelAndView.addObject("positionId", positionId);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
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

    @PostMapping("/update")
    public String update (@Valid @ModelAttribute("employeeDto") EmployeeDto employeeDto, BindingResult bindingResult) {
        List<Employee> employees = employeeService.findAll();
        Optional<Employee> employeeOptional = employeeService.findById(employeeDto.getEmployeeId());
        String oldEmail = employeeOptional.get().getEmployeeEmail();
        if (!oldEmail.equals(employeeDto.getEmployeeEmail())) {
            EmployeeDto employeeDtoTemp = new EmployeeDto();
            employeeDtoTemp.setEmployees(employees);
            employeeDtoTemp.validate(employeeDto, bindingResult);
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

    @PostMapping("/delete")
    public String delete (@RequestParam Long idEmployee) {
        employeeService.remove(idEmployee);
        return "redirect:/employee";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiple (@RequestParam String idEmployeeMultiple) {
        String[] idEmployeeMultipleArray = idEmployeeMultiple.split(",");
        for (int i = 0; i < idEmployeeMultipleArray.length; i++) {
            employeeService.remove(Long.valueOf(idEmployeeMultipleArray[i]));
        }
        return "redirect:/employee";
    }
}
