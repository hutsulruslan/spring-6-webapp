package com.hutsdev.spring6webapp.bootstrap;

import com.hutsdev.spring6webapp.domain.Author;
import com.hutsdev.spring6webapp.domain.Book;
import com.hutsdev.spring6webapp.domain.Publisher;
import com.hutsdev.spring6webapp.repositories.AuthorRepository;
import com.hutsdev.spring6webapp.repositories.BookRepository;
import com.hutsdev.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author eric = new Author();
        eric.setFirstName("Eric");
        eric.setLastName("Evans");

        Book book1 = new Book();
        book1.setTitle("Solo Leveling");
        book1.setIsbn("12345");

        Author ericSaved = authorRepository.save(eric);
        Book book1Saved = bookRepository.save(book1);

        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Doe");

        Book book2 = new Book();
        book2.setTitle("Devil May Cry");
        book2.setIsbn("455352");

        Author johnSaved = authorRepository.save(john);
        Book book2Saved = bookRepository.save(book2);

        ericSaved.getBooks().add(book1Saved);
        johnSaved.getBooks().add(book2Saved);

        authorRepository.save(ericSaved);
        authorRepository.save(johnSaved);

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Light Text Coop");
        publisher.setAddress("12 st. fg");
        publisher.setCity("Lviv");
        publisher.setState("Ukraine");
        publisher.setZip("48500");

        publisherRepository.save(publisher);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
