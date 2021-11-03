package com.codegym.service.impl;

import com.codegym.model.Division;
import com.codegym.repository.IDivisionRepository;
import com.codegym.service.IDivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DivisionServiceImpl implements IDivisionService {
    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return divisionRepository.findAll();
    }

    @Override
    public Optional<Division> findById(Long id) {
        return divisionRepository.findById(id);
    }

    @Override
    public void save(Division division) {
        divisionRepository.save(division);
    }

    @Override
    public void remove(Long id) {
        divisionRepository.deleteById(id);
    }
}
