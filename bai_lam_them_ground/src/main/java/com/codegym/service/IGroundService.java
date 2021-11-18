package com.codegym.service;

import com.codegym.model.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IGroundService extends IGeneralService<Ground> {
    Page<Ground> findAll (Pageable pageable, String floor, String money, String ground_type_id);
}
