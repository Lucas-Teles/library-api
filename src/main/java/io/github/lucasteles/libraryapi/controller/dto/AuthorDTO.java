package io.github.lucasteles.libraryapi.controller.dto;

import io.github.lucasteles.libraryapi.model.Author;

import java.time.LocalDate;

public record AuthorDTO(String name,
                        LocalDate dateOfBirth,
                        String nationality) {

    public Author mapToAuthor(){
        Author author = new Author();
        author.setName(this.name);
        author.setDateOfBirth(this.dateOfBirth);
        author.setNationality(this.nationality);
        return author;
    }

}
