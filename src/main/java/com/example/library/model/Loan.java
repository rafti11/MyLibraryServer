package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "loan")
@Getter @Setter
public class Loan {

    @Id
    @Column(name = "date_out")
    private String dateOut;

    @Column(name = "date_returned")
    private String dateReturned;

    @Column(name = "date_due")
    private String dateDue;

    @Column(name = "client_id")
    private int clientId;

    @Column(name = "catalog_id")
    private int catalogId;

}