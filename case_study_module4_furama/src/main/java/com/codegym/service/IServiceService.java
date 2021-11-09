package com.codegym.service;

import com.codegym.dto.ServiceDetail;
import com.codegym.model.Service;

import java.util.List;

public interface IServiceService extends IGeneralService<Service> {
    List<ServiceDetail> listServiceDetail();

    List<ServiceDetail> listServiceDetailById(Integer id);
}
