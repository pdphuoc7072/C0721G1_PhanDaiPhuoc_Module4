package com.codegym.service;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationService {
    List<MedicalDeclaration> findAll ();
    void save (MedicalDeclaration medicalDeclaration);
    MedicalDeclaration findById (int id);
    void update (int id, MedicalDeclaration medicalDeclaration);
}
