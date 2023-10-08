package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name = "shelf")
public class Shelf {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_number")
    private int bookNumber;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "isbn_id", referencedColumnName = "isbn", unique = true)
    @JoinColumn(name = "catalog_isbn", referencedColumnName = "isbn", unique = true)
    private BookDetails bookDetails;

}
