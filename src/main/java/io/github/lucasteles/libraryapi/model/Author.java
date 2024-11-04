package io.github.lucasteles.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "autor")
@Data
public class Author {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "nome", length = 100, nullable = false)
    private String name;
    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dateOfBirth;
    @Column(name = "nacionalidade", length = 50, nullable = false)
    private String nationality;
    @OneToMany(mappedBy = "idAuthor")
    private List<Book> books;

    public Author() {
    }
}
