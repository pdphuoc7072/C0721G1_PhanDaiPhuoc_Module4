package com.codegym.repository;

import com.codegym.model.Ground;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IGroundRepository extends JpaRepository<Ground, Long> {
    @Query(value = "SELECT * FROM ground WHERE floor LIKE :floor AND money LIKE :money " +
            "AND ground_type_id LIKE :ground_type_id", nativeQuery = true)
    Page<Ground> findAll (Pageable pageable, @Param("floor") String floor,
                        @Param("money") String money, @Param("ground_type_id") String ground_type_id);
}
