package com.example.library.controller;

import com.example.library.data.BookRepository;
import com.example.library.model.Book;
import com.example.library.model.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;



    @RequestMapping(value = "book/all")
    public Iterable<Book> getAllBooks() {

        return bookRepository.findAll();

    }

    // Todo: return a response when the book is created
    @RequestMapping(value = "book/create")
//    @ResponseBody
    public void createBook(@RequestBody Book book) {

        Catalog catalog = new Catalog(book);

        book.setCatalog(catalog);

//        bookRepository.save(book);

    }



}
