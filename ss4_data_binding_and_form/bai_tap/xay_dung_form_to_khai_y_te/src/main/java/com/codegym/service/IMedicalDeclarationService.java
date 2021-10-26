package com.codegym.service;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    List<MedicalDeclaration> findAll ();
    void save (MedicalDeclaration medicalDeclaration);
}
