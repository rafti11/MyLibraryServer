package com.example.library.controller;

import com.example.library.data.AuthorRepository;
import com.example.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "author/all")
    public Iterable<Author> getAllAuthor() {
        return authorRepository.findAll();
    }


    @RequestMapping(value = "author/create")
    public void setAuthor(@RequestBody Author author) {

        authorRepository.save(author);

    }


}
