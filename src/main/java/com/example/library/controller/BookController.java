package com.example.library.controller;

import com.example.library.data.BookRepository;
import com.example.library.data.ShelfRepository;
import com.example.library.model.BookDetails;
import com.example.library.model.Shelf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.serial.SerialJavaObject;
import java.util.List;
import java.util.Optional;

@RestController
public class BookController {

    @Autowired
    private BookRepository bookRepository;
//    @Autowired
//    private ShelfRepository shelf;

    @RequestMapping(value = "book/all")
    public Iterable<BookDetails> getAllBooks() {

        return bookRepository.findAll();

    }

    // Todo: return a response when the book is created
    @RequestMapping(value = "book/create")
//    @ResponseBody
    public void createBook(@RequestBody BookDetails bookDetails) {

//        bookRepository.save(bookDetails);
//
//        // Verify working, commented for future use.
//        Optional<BookDetails> bb = bookRepository.findById(bookDetails.getIsbn());
//        if (bb.isPresent()) {
//            boolean st = bookDetails.getIsbn() == bb.get().getIsbn();
//            System.out.println(st);
//        }


//        BookDetails bk = new BookDetails();
//        bk.setIsbn(1233333);
//        bk.setTitle("sss");
//        bk.setPublisher("fsdf");
//        bk.setPubDate(222);
//        Shelf shelf = new Shelf();
//        shelf.setBookDetails(bk);
//        bk.setShelf(shelf);
//        bookRepository.save(bk);

        Shelf sh = new Shelf();
        sh.setBookDetails(bookDetails);

        bookDetails.setShelf(sh);

        bookRepository.save(bookDetails);

    }



}
