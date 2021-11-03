package com.codegym.repository;

import com.codegym.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    @Query(value = "SELECT * FROM employee WHERE employee_name LIKE :employee_name AND employee_phone LIKE :employee_phone " +
            "AND position_id LIKE :position_id", nativeQuery = true)
    Page<Employee> findAll (Pageable pageable, @Param("employee_name") String employee_name,
                            @Param("employee_phone") String employee_phone, @Param("position_id") String position_id);
}
