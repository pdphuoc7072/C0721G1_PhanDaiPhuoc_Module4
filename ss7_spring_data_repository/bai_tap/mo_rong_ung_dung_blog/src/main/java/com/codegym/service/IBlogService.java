package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll (Pageable pageable);
    Page<Blog> findAllByTitleContaining (String title, Pageable pageable);
    Iterable<Blog> findAllByCategory (Category category);
    Page<Blog> findAllByOrderByCreateDayAsc (Pageable pageable);
    Page<Blog> findAllByOrderByCreateDayDesc (Pageable pageable);
}
