package com.codegym.repository;

import com.codegym.model.Account;
import com.codegym.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername (String username);

    @Query(value = "SELECT * FROM account WHERE flag=:flag", nativeQuery = true)
    List<Account> findByFlag (@Param("flag") Boolean flag);
}
