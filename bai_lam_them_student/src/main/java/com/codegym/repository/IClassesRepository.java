package com.codegym.repository;

import com.codegym.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassesRepository extends JpaRepository<Classes, Long> {
}
