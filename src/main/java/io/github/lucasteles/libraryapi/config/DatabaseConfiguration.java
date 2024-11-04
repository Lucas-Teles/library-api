package io.github.lucasteles.libraryapi.config;

import io.github.lucasteles.libraryapi.repository.AuthorRepository;
import io.github.lucasteles.libraryapi.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfiguration implements CommandLineRunner {
    public static final Logger log = LoggerFactory.getLogger(DatabaseConfiguration.class);
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public DatabaseConfiguration(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        log.info("BORA LUCÃO");
        log.info("O banco conectou :D");
    }

}
