package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BookBorrow {

    @Id
    private Long codeBorrow;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "id_book", referencedColumnName = "id")
    private Book book;

    public BookBorrow() {
    }

    public BookBorrow(Long codeBorrow, Book book) {
        this.codeBorrow = codeBorrow;
        this.book = book;
    }

    public Long getCodeBorrow() {
        return codeBorrow;
    }

    public void setCodeBorrow(Long codeBorrow) {
        this.codeBorrow = codeBorrow;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
