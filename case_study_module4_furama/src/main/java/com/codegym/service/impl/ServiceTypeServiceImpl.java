package com.codegym.service.impl;

import com.codegym.model.ServiceType;
import com.codegym.repository.IServiceTypeRepository;
import com.codegym.service.IServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Long id) {
        return serviceTypeRepository.findById(id);
    }

    @Override
    public void save(ServiceType serviceType) {
        serviceTypeRepository.save(serviceType);
    }

    @Override
    public void remove(Long id) {
        serviceTypeRepository.deleteById(id);
    }
}
