package com.codegym.repository;

import com.codegym.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICityRepository extends JpaRepository<City, Long> {
    @Query(value = "SELECT * FROM city WHERE `code` LIKE :code AND `name` LIKE :name " +
            "AND country_id LIKE :country_id", nativeQuery = true)
    Page<City> findAll (Pageable pageable, @Param("code") String code,
                            @Param("name") String name, @Param("country_id") String country_id);
}
