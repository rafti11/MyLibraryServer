package com.example.library.controller;

import com.example.library.data.BookRepository;
import com.example.library.model.Author;
import com.example.library.model.Book;
import com.example.library.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/v1/book")
@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;



    @RequestMapping(value = "all")
    public Iterable<Book> getAllBooks() {

        return bookRepository.findAll();

    }

    @RequestMapping(value = "{id}")
    public ResponseEntity<Book> getBook(@PathVariable int id) {

        Book bk = bookRepository.findById(id).orElse(null);
        return new ResponseEntity<>(bk, HttpStatus.OK);

    }

    // Todo: return a response when the book is created
    @RequestMapping(value = "create")
//    @ResponseBody
    public void createBook(@RequestBody Book book) {


        Book bk = bookRepository.save(book);

        Catalog catalog = new Catalog(book);

        bk.setCatalog(catalog);

        bookRepository.save(bk);


    }

    @DeleteMapping(value = "delete/{id}")
//    @ResponseBody
    public ResponseEntity<String> deleteBook(@RequestBody Book book) {


        Book bk = bookRepository.findById(book.getId()).orElse(null);
        String msg = "Book deleted correctly";

        if (bk != null) {

            try {

                bookRepository.delete(bk);
                return new ResponseEntity<>(msg, HttpStatus.OK);

            } catch (DataIntegrityViolationException e) {
                System.err.println(e.getMessage());
                msg = "Book couldn't be deleted. Please remove the catalog of this book first.";
                return new ResponseEntity<>(msg, HttpStatus.METHOD_NOT_ALLOWED);
            }

        }

        msg = "Book couldn't be deleted";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }


    @PutMapping(value = "update")
    public ResponseEntity<String> updateBook(@RequestBody Book book) {

        Book bk = bookRepository.findById(book.getId()).orElse(null);

        String msg = "Book don't exists";

        if (bk == null) {
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }

        bookRepository.save(book);
        msg = "Book updated";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

}
