package com.softrelic.books.bootstrap;

import com.softrelic.books.domain.Book;
import com.softrelic.books.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootstrapData implements CommandLineRunner {

    private final BookRepository bookRepository;
    BootstrapData(BookRepository repository){
           this.bookRepository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Initializing book object");
//        Book book = new Book();
//        book.setTitle("Head first java");
//        book.setIsbn("123223232");
//        bookRepository.save(book);
//
//        List<Book> books = bookRepository.findAll();
//        long count = bookRepository.count();
//        System.out.println("total books in the database "+ count);
    }
}
