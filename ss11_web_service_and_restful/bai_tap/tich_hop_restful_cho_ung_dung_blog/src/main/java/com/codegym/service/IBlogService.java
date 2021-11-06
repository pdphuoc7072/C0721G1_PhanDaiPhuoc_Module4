package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.repository.query.Param;

public interface IBlogService extends IGeneralService<Blog> {
    Iterable<Blog> findByCategoryId (Long id);
}
