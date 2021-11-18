package com.codegym.service;

import com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface ICityService extends IGeneralService<City> {
    Page<City> findAll (Pageable pageable, String code, String name, String country_id);
}
