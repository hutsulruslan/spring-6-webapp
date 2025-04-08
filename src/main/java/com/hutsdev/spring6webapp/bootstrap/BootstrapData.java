package com.hutsdev.spring6webapp.bootstrap;

import com.hutsdev.spring6webapp.domain.Author;
import com.hutsdev.spring6webapp.domain.Book;
import com.hutsdev.spring6webapp.repositories.AuthorRepository;
import com.hutsdev.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
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

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
