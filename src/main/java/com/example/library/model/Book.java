package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter @Setter
public class Book {

    @Id
    private Long isbn;
    private String title;
    @Column(name = "pub_date")
    private int pubDate;
    private int pages;
//    private String publisher;

    // Name of variable in shelf
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private Catalog catalog;


}
