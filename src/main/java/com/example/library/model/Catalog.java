package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "catalog")
public class Catalog {

    @Id
    @Column(name = "catalog_id")
    private int catalogNumber;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn", unique = true)
    @JsonIgnore
    @JoinColumn(name = "book_isbn")
    private Book book;

    public Catalog() {
    }

    public Catalog(Book book) {
        this.book = book;
    }
}
