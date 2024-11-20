package com.softrelic.books.controllers;

import com.softrelic.books.domain.Book;
import com.softrelic.books.repositories.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
   private final BookRepository  bookRepository;

   BookController(BookRepository repository){
       this.bookRepository = repository;
   }
   @GetMapping()
  List<Book>  findAll(){
     return bookRepository.findAll();
   }

}
