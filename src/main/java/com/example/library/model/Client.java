package com.example.library.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Table(name = "client")
public class Client {

    @Getter @Setter
    private int codClient;
    @Getter @Setter
    private String personalId;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private String lastName;
    @Getter @Setter
    private int phone;
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String address;

}
