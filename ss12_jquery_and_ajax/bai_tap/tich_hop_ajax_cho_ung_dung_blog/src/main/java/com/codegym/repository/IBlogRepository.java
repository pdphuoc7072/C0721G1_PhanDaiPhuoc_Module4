package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    Page<Blog> findAllByCategoryId (Long id, Pageable pageable);

    List<Blog> findAllByTitleContains(String title);

    Page<Blog> findAllByTitleContains(String title, Pageable pageable);
}
