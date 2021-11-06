package com.codegym.repository;

import com.codegym.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Long> {
    @Query(value = "SELECT * FROM blog WHERE category_id=:id", nativeQuery = true)
    Iterable<Blog> findByCategoryId (@Param("id") Long id);
}
