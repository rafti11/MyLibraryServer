package com.example.library.controller;

import com.example.library.data.AuthorRepository;
import com.example.library.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping(value = "api/author")
@RestController
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @RequestMapping(value = "all")
    public List<Author> getAllAuthor() {
        return authorRepository.findAll();
    }

    @RequestMapping(value = "{id}")
    public ResponseEntity<Author> getAuthor(@PathVariable int id) {

        Author au = authorRepository.findById(id).orElse(null);
        return new ResponseEntity<>(au, HttpStatus.OK);

    }


    @PostMapping(value = "create")
    public ResponseEntity<String> setAuthor(@RequestBody Author author) {

        Author au = authorRepository.save(author);
        String msg = "Author created correctly";

        if (author.getName().equals(au.getName())) {
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }

        msg = "Author couldn't be created";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteAuthor(@PathVariable("id") int id) {

        Author au = authorRepository.findById(id).orElse(null);
        String msg = "Author deleted correctly";

        if (au != null) {

            try {

                authorRepository.delete(au);
                return new ResponseEntity<>(msg, HttpStatus.OK);

            } catch (DataIntegrityViolationException e) {
                System.err.println(e.getMessage());
                msg = "Author couldn't be deleted. Please remove the books of this author first.";
                return new ResponseEntity<>(msg, HttpStatus.METHOD_NOT_ALLOWED);
            }

        }

        msg = "Author couldn't be deleted";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }


    @PutMapping(value = "update")
    public ResponseEntity<String> updateAuthor(@RequestBody Author author) {

        Author au = authorRepository.findById(author.getId()).orElse(null);

        String msg = "Author don't exists";

        if (au == null) {
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }

        authorRepository.save(author);
        msg = "Author updated";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }


}
