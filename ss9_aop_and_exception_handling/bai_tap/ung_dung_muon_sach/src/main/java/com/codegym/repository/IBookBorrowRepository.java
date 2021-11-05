package com.codegym.repository;

import com.codegym.model.BookBorrow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookBorrowRepository extends JpaRepository<BookBorrow, Long> {
}
