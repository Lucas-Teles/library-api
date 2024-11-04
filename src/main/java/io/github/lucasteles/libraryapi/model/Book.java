package io.github.lucasteles.libraryapi.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "livro")
@Data
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;
    @Column(name = "titulo", length = 150, nullable = false)
    private String title;
    @Column(name = "data_publicacao", nullable = false)
    private LocalDate publicationDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "genero", length = 30, nullable = false)
    private BookGender gender;
    @Column(name = "preco", precision = 18, scale = 2)
    private BigDecimal price;
    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Author idAuthor;

    public Book() {
    }
}
