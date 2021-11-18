package com.codegym.service.impl;

import com.codegym.model.GroundType;
import com.codegym.repository.IGroundTypeRepository;
import com.codegym.service.IGroundTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroundTypeServiceImpl implements IGroundTypeService {
    @Autowired
    private IGroundTypeRepository groundTypeRepository;

    @Override
    public List<GroundType> findAll() {
        return groundTypeRepository.findAll();
    }

    @Override
    public Optional<GroundType> findById(Long id) {
        return groundTypeRepository.findById(id);
    }

    @Override
    public void save(GroundType groundType) {
        groundTypeRepository.save(groundType);
    }

    @Override
    public void remove(Long id) {
        groundTypeRepository.deleteById(id);
    }
}
