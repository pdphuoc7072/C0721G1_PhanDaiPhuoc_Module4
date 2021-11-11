package com.codegym.service;

import com.codegym.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Optional<Smartphone> findById(Integer id);

    Smartphone save(Smartphone smartphone);

    void remove(Integer id);
}
