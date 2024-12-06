package com.softrelic.books.repositories;

import com.softrelic.books.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findBooksByTitle(String title);
    List<Book> findBooksByTitleLike(String title);
}
