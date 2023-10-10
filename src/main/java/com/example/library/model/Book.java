package com.example.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter @Setter
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private Long isbn;

    private String title;

    @Column(name = "pub_date")
    private int pubDate;

    private int pages;
//    private String publisher;

    // Name of variable in shelf
    @OneToOne(mappedBy = "book", cascade = CascadeType.ALL)
    private Catalog catalog;

//    @JsonIgnore
//    @JoinColumn(name = "language_id")
//    private Language language;
    @Column(name = "language_id")
    private int language;

//    @JsonIgnore
//    @JoinColumn(name = "author_id")
//    private Author author;
    @Column(name = "author_id")
    private int author;


}
