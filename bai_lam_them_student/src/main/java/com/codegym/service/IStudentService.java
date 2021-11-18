package com.codegym.service;

import com.codegym.model.Student;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentService extends IGeneralService<Student> {
    List<Student> findByFlag (Boolean flag);
}
