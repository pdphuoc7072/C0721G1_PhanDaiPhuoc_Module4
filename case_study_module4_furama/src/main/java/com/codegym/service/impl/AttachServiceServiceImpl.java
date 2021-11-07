package com.codegym.service.impl;

import com.codegym.model.AttachService;
import com.codegym.repository.IAttachServiceRepository;
import com.codegym.service.IAttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttachServiceServiceImpl implements IAttachServiceService {
    @Autowired
    private IAttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return attachServiceRepository.findAll();
    }

    @Override
    public Optional<AttachService> findById(Long id) {
        return attachServiceRepository.findById(id);
    }

    @Override
    public void save(AttachService attachService) {
        attachServiceRepository.save(attachService);
    }

    @Override
    public void remove(Long id) {
        attachServiceRepository.deleteById(id);
    }
}
