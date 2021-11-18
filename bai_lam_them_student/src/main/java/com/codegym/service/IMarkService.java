package com.codegym.service;

import com.codegym.model.Mark;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMarkService extends IGeneralService<Mark> {
    List<Mark> findByStudentId (Long student_id);

    List<Mark> findByFlag (Boolean flag);
}
