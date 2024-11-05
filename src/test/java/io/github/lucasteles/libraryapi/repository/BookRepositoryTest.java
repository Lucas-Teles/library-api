package io.github.lucasteles.libraryapi.repository;


import io.github.lucasteles.libraryapi.model.Author;
import io.github.lucasteles.libraryapi.model.Book;
import io.github.lucasteles.libraryapi.model.BookGender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository repository;

    @Autowired
    AuthorRepository authorRepository;

    @Test
    void saveTest(){
        Book book = new Book();
        book.setIsbn("123456-78910");
        book.setPrice(BigDecimal.valueOf(100));
        book.setGender(BookGender.FANTASIA);
        book.setTitle("Fantasias da programação");
        book.setPublicationDate(LocalDate.of(2000, 11, 11));

        Author author = authorRepository
                .findById(UUID.fromString("48c51fa5-e333-40ae-b538-d29dfb13f8b1"))
                .orElse(null);

        book.setAuthor(author);

        repository.save(book);
    }


}