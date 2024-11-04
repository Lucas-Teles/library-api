package io.github.lucasteles.libraryapi.repository;

import io.github.lucasteles.libraryapi.model.Author;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AuthorRepositoryTest {
    @Autowired
    AuthorRepository repository;

    @Test
    void saveTest() {
        Author author = new Author();
        author.setName("Maria");
        author.setNationality("Brasileira");
        author.setDateOfBirth(
                LocalDate.of(1999, 8, 22)
        );

        var savedAuthor = repository.save(author);
        System.out.println("Autor salvo: " + savedAuthor);

    }

    @Test
    void updateTest() {
        var id = UUID.fromString("362cfa38-2e7e-4158-9b92-372a5418b420");
        Optional<Author> possibleAuthor = repository.findById(id);
        if (possibleAuthor.isPresent()) {
            Author foundAuthor = possibleAuthor.get();
            System.out.println("Dados do Autor");
            System.out.println(foundAuthor);

            foundAuthor.setNationality("Inglesa");
            repository.save(foundAuthor);
        }
    }

    @Test
    void listAuthorsTest() {
        List<Author> listAuthors = repository.findAll();
        listAuthors.forEach(System.out::println);
    }

    @Test
    void countTest() {
        System.out.println("Contagem de autores: " + repository.count());
    }

    @Test
    void deleteByIdTest() {
        var id = UUID.fromString("362cfa38-2e7e-4158-9b92-372a5418b420");
        repository.deleteById(id);
    }

    @Test
    void deleteAllTest() {
        repository.deleteAll();
        System.out.println("dados apagados");
    }
}
