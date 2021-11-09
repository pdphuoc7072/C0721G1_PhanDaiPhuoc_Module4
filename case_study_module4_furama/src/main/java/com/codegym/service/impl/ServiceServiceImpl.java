package com.codegym.service.impl;

import com.codegym.dto.ServiceDetail;
import com.codegym.model.Service;
import com.codegym.repository.IServiceRepository;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService {
    @Autowired
    private IServiceRepository serviceRepository;

    @Override
    public List<Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public void save(Service service) {
        serviceRepository.save(service);
    }

    @Override
    public void remove(Long id) {
        serviceRepository.deleteById(id);
    }


    @Override
    public List<ServiceDetail> listServiceDetail() {
        return serviceRepository.listServiceDetail();
    }

    @Override
    public List<ServiceDetail> listServiceDetailById(Integer id) {
        return serviceRepository.listServiceDetailById(id);
    }
}
