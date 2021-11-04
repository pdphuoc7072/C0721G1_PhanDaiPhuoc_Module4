package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICustomerService extends IGeneralService<Customer> {
    Page<Customer> findAll (Pageable pageable, String customer_name, String customer_phone, String customer_type_id);
}
