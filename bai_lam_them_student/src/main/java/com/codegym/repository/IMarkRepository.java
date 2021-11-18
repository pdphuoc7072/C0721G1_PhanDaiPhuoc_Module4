package com.codegym.repository;

import com.codegym.model.Account;
import com.codegym.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMarkRepository extends JpaRepository<Mark, Long> {
    @Query(value = "SELECT * FROM mark WHERE student_id=:student_id", nativeQuery = true)
    List<Mark> findByStudentId (@Param("student_id") Long student_id);

    @Query(value = "SELECT * FROM mark WHERE flag=:flag", nativeQuery = true)
    List<Mark> findByFlag (@Param("flag") Boolean flag);
}
