package com.codegym.service.impl;

import com.codegym.model.Mark;
import com.codegym.repository.IMarkRepository;
import com.codegym.service.IMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarkServiceImpl implements IMarkService {
    @Autowired
    private IMarkRepository markRepository;

    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    @Override
    public Optional<Mark> findById(Long id) {
        return markRepository.findById(id);
    }

    @Override
    public void save(Mark mark) {
        markRepository.save(mark);
    }

    @Override
    public List<Mark> findByStudentId(Long student_id) {
        return markRepository.findByStudentId(student_id);
    }

    @Override
    public List<Mark> findByFlag(Boolean flag) {
        return markRepository.findByFlag(flag);
    }
}
