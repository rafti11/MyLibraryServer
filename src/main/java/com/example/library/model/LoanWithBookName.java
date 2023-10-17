package com.example.library.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
public class LoanWithBookName {

    private String dateOut;
    private String dateReturned;
    private String dateDue;
    private String title;
//    private int catalogId;

}