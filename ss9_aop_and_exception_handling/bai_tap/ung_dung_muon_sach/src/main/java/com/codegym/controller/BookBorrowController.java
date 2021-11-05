package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.BookBorrow;
import com.codegym.service.IBookBorrowService;
import com.codegym.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/borrow-and-return")
public class BookBorrowController {
    @Autowired
    private IBookBorrowService bookBorrowService;

    @Autowired
    private IBookService bookService;

    @PostMapping("/borrow-book")
    public ModelAndView borrow (@ModelAttribute Book book) throws Exception {
        if (book.getQuantity() > 0) {
            Long codeBorrow = Long.valueOf((long) (Math.random()*100000));
            BookBorrow bookBorrow = new BookBorrow(codeBorrow, book);
            bookBorrowService.save(bookBorrow);
            book.setQuantity(book.getQuantity()-1);
            bookService.save(book);
            ModelAndView modelAndView = new ModelAndView("book/list");
            modelAndView.addObject("books", bookService.findAll());
            modelAndView.addObject("message", "Bạn đã mượn thành công. Mã số mượn sách của bạn là: " + codeBorrow);
            return modelAndView;
        } else {
            throw new Exception("Lỗi");
        }
    }

    @GetMapping("/return-book")
    public ModelAndView showFormReturnBook () {
        ModelAndView modelAndView = new ModelAndView("borrow/index");
        modelAndView.addObject("bookBorrow", new BookBorrow());
        return modelAndView;
    }

    @PostMapping("")
    public String returnBook (@ModelAttribute BookBorrow bookBorrow, RedirectAttributes redirectAttributes) throws Exception {
        Optional<BookBorrow> bookBorrowOptional = bookBorrowService.findById(bookBorrow.getCodeBorrow());
        if (bookBorrowOptional.isPresent()) {
            Optional<Book> bookOptional = bookService.findById(bookBorrowOptional.get().getBook().getId());
            bookOptional.get().setQuantity(bookOptional.get().getQuantity()+1);
            bookService.save(bookOptional.get());
            bookBorrowService.remove(bookBorrow.getCodeBorrow());
        } else {
            throw new Exception("Lỗi");
        }
        redirectAttributes.addFlashAttribute("message", "Bạn đã trả sách thành công");
        return "redirect:/book";
    }

    @ExceptionHandler
    public String showErrorPage () {
        return "error";
    }

}
