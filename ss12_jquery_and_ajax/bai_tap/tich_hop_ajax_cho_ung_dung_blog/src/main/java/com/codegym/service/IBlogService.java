package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAllByTitleContains(String title);

    Page<Blog> findAllByTitleContains(String title, Pageable pageable);

    Page<Blog> findAllByCategoryId(Long id, Pageable pageable);

    Blog findById (Long id);
}
