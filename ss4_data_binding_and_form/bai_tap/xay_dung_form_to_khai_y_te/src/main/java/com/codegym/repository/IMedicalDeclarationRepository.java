package com.codegym.repository;

import com.codegym.model.MedicalDeclaration;

import java.util.List;

public interface IMedicalDeclarationRepository {
    List<MedicalDeclaration> findAll ();
    void save (MedicalDeclaration medicalDeclaration);
}
