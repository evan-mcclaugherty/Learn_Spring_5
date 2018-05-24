package com.evan.spring5webapp.bootstrap;

import com.evan.spring5webapp.model.Author;
import com.evan.spring5webapp.model.Book;
import com.evan.spring5webapp.model.Publisher;
import com.evan.spring5webapp.repositories.AuthorRepository;
import com.evan.spring5webapp.repositories.BookRepository;
import com.evan.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author evan = new Author("Evan", "McClaugherty");
        Publisher iPub = new Publisher("IPubBooks", "1234 Main St.");
        publisherRepository.save(iPub);
        Book ddd = new Book("Domain Driven Design", "1234", iPub);
        evan.getBooks().add(ddd);
        ddd.getAuthors().add(evan);

        authorRepository.save(evan);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Publisher worx = new Publisher("Worx", "435 Different St.");
        publisherRepository.save(worx);
        Book noEJB = new Book("J2EE Development without EJB", "2344", worx);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
