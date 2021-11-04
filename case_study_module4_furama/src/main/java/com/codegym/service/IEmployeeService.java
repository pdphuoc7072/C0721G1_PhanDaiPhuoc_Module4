package com.codegym.service;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IEmployeeService extends IGeneralService<Employee> {
    Page<Employee> findAll (Pageable pageable, String employee_name, String employee_phone, String position_id);
}
