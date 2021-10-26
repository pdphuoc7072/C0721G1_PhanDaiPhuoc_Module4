package com.codegym.service.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;
import com.codegym.service.IMedicalDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalDeclarationServiceImpl implements IMedicalDeclarationService {
    @Autowired
    private IMedicalDeclarationRepository medicalDeclarationRepository;

    @Override
    public List<MedicalDeclaration> findAll() {
        return null;
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {

    }
}
