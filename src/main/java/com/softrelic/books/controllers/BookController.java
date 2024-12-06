package com.softrelic.books.controllers;

import com.softrelic.books.domain.Book;
import com.softrelic.books.repositories.BookRepository;
import com.softrelic.books.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    List<Book> findAll(@RequestParam("search") String search) {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book findBook(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable("id") Long id) {
        bookService.delete(id);
    }

    @GetMapping("/find/{title}")
    public List<Book> findByTitle(@PathVariable("title") String title){
        return bookService.findByTitle(title);
    }

}
