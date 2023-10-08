package com.example.library.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name = "catalog_card")
@Getter @Setter
public class BookDetails {

    @Id
    private int isbn;
    private String title;
    @Column(name = "pub_date")
    private int pubDate;
    private String publisher;

    // Name of variable in shelf
    @OneToOne(mappedBy = "bookDetails", cascade = CascadeType.ALL)
    private Shelf shelf;

//    public BookDetails() {
//        System.out.println("is: " + getIsbn());
//        shelf = new Shelf();
//        shelf.setBookDetails(this);
//    }
}
