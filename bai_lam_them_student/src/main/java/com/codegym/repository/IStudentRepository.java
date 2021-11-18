package com.codegym.repository;

import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    @Query(value = "SELECT * FROM student WHERE flag=:flag", nativeQuery = true)
    List<Student> findByFlag (@Param("flag") Boolean flag);
}
