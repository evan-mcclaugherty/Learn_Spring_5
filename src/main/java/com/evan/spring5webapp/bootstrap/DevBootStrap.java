package com.evan.spring5webapp.bootstrap;

import com.evan.spring5webapp.model.Author;
import com.evan.spring5webapp.model.Book;
import com.evan.spring5webapp.repositories.AuthorRepository;
import com.evan.spring5webapp.repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author evan = new Author("Evan", "McClaugherty");
        Book ddd = new Book("Domain Driven Design", "1234", "Harper Collins");
        evan.getBooks().add(ddd);
        ddd.getAuthors().add(evan);

        authorRepository.save(evan);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "2344", "Worx");
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
    }
}
