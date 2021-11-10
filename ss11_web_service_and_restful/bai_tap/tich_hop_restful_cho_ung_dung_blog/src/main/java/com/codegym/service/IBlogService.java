package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findByCategoryId (Long id);

    Page<Blog> findAll (Pageable pageable);
}
