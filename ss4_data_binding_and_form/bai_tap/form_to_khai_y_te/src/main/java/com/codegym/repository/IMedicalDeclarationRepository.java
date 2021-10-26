package com.codegym.repository;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {
    List<MedicalDeclaration> findAll ();
    void save (MedicalDeclaration medicalDeclaration);
    MedicalDeclaration findById (int id);
    void update (int id, MedicalDeclaration medicalDeclaration);
}
