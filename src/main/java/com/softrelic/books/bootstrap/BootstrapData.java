package com.softrelic.books.bootstrap;

import com.softrelic.books.domain.Address;
import com.softrelic.books.domain.Author;
import com.softrelic.books.domain.Book;
import com.softrelic.books.domain.Publisher;
import com.softrelic.books.repositories.AddressRepository;
import com.softrelic.books.repositories.AuthorRepository;
import com.softrelic.books.repositories.BookRepository;
import com.softrelic.books.repositories.PublisherRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private Faker faker = new Faker();

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final AddressRepository addressRepository;
    private final PublisherRepository publisherRepository;
    BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, AddressRepository addressRepository, PublisherRepository publisherRepository ){
           this.bookRepository = bookRepository;
           this.addressRepository = addressRepository;
           this.authorRepository = authorRepository;
           this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Address addressOne = new Address();
        addressOne.setCity(faker.address().city());
        addressOne.setState(faker.address().state());
        addressOne.setStreet(faker.address().streetAddress());
        addressOne.setZipCode(faker.address().zipCode());
        Address savedAddressOne = addressRepository.save(addressOne);

        Address addressTwo = new Address();
        addressTwo.setCity(faker.address().city());
        addressTwo.setState(faker.address().state());
        addressTwo.setStreet(faker.address().streetAddress());
        addressTwo.setZipCode(faker.address().zipCode());
        Address savedAddressTwo = addressRepository.save(addressTwo);

        Author authorOne = new Author();
        authorOne.setName(faker.name().name());
        authorOne.setEmail(faker.internet().emailAddress());
        authorOne.setContact(faker.phoneNumber().cellPhone());
        authorOne.setAddress(savedAddressOne);
        Author  savedAuthorOne = authorRepository.save(authorOne);

        Author authorTwo = new Author();
        authorTwo.setName(faker.name().name());
        authorTwo.setEmail(faker.internet().emailAddress());
        authorTwo.setContact(faker.phoneNumber().cellPhone());
        authorTwo.setAddress(savedAddressTwo);
        Author savedAuthorTwo = authorRepository.save(authorTwo);

        Publisher publisherOne = new Publisher();
        publisherOne.setName(faker.name().name());
        publisherOne.setEmail(faker.internet().emailAddress());
        publisherOne.setContact(faker.phoneNumber().cellPhone());
        publisherOne.setAddress(savedAddressOne);

        Publisher savedPublisherOne = publisherRepository.save(publisherOne);

        Book bookOne = new Book();
        bookOne.setTitle(faker.book().title());
        bookOne.setIsbn(faker.number().digits(13));
        bookOne.setPrice(faker.number().numberBetween(100, 1000));
        bookOne.setPublishDate(faker.date().birthday());
        bookOne.setPublisher(savedPublisherOne);
        bookOne.getAuthors().add(savedAuthorOne);
        bookOne.getAuthors().add(savedAuthorTwo);
        Book savedBookOne = bookRepository.save(bookOne);


    }
}
