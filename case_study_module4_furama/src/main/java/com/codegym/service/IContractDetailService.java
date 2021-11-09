package com.codegym.service;

import com.codegym.model.ContractDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractDetailService extends IGeneralService<ContractDetail> {
    Page<ContractDetail> findAll (Pageable pageable);
}
