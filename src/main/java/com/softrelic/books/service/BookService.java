package com.softrelic.books.service;

import com.softrelic.books.domain.Book;
import com.softrelic.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            return optionalBook.get();
        }
        throw new RuntimeException("Book not found");
    }

    public void delete(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitle(String title){
        return bookRepository.findBooksByTitle(title);
    }
}
