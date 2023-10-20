package com.example.library.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {

    private String email;
    private String firstname;
    private String lastname;
    private String password;
    private String personalId;
    private String address;
    private int phone;

}
