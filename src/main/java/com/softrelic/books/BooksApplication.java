package com.softrelic.books;

import com.softrelic.books.domain.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		Book book = new Book();
		SpringApplication.run(BooksApplication.class, args);
	}

}
