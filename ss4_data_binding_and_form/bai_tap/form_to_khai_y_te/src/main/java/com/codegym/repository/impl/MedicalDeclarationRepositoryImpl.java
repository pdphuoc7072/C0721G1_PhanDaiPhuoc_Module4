package com.codegym.repository.impl;

import com.codegym.model.MedicalDeclaration;
import com.codegym.repository.IMedicalDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MedicalDeclarationRepositoryImpl implements IMedicalDeclarationRepository {
    Map<Integer, MedicalDeclaration> medicalDeclarationList = new HashMap<>();

    @Override
    public List<MedicalDeclaration> findAll() {
        return new ArrayList<>(medicalDeclarationList.values());
    }

    @Override
    public void save(MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.put(medicalDeclaration.getIdForm(), medicalDeclaration);
    }

    @Override
    public MedicalDeclaration findById(int id) {
        return medicalDeclarationList.get(id);
    }

    @Override
    public void update(int id, MedicalDeclaration medicalDeclaration) {
        medicalDeclarationList.put(id, medicalDeclaration);
    }
}
