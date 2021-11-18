package com.codegym.service.impl;

import com.codegym.model.Ground;
import com.codegym.repository.IGroundRepository;
import com.codegym.service.IGroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroundServiceImpl implements IGroundService {
    @Autowired
    private IGroundRepository groundRepository;

    @Override
    public Page<Ground> findAll(Pageable pageable, String floor, String money, String ground_type_id) {
        return groundRepository.findAll(pageable, "%"+floor+"%", "%"+money+"%", "%"+ground_type_id+"%");
    }

    @Override
    public List<Ground> findAll() {
        return groundRepository.findAll();
    }

    @Override
    public Optional<Ground> findById(Long id) {
        return groundRepository.findById(id);
    }

    @Override
    public void save(Ground ground) {
        groundRepository.save(ground);
    }

    @Override
    public void remove(Long id) {
        groundRepository.deleteById(id);
    }
}
