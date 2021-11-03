package com.codegym.controller;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Employee;
import com.codegym.model.Position;
import com.codegym.service.IDivisionService;
import com.codegym.service.IEducationDegreeService;
import com.codegym.service.IEmployeeService;
import com.codegym.service.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        ModelAndView modelAndView = new ModelAndView("/employee/create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save (@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee";
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
}
