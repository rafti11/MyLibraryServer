package com.example.library.controller;

import com.example.library.data.BookRepository;
import com.example.library.data.CatalogRepository;
import com.example.library.data.LoanRepository;
import com.example.library.model.Book;
import com.example.library.model.Catalog;
import com.example.library.model.Loan;
import com.example.library.model.LoanWithBookName;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequestMapping("/api/v1/loan")
@RestController
public class LoanController {

    @Autowired
    private LoanRepository loanRepository;


    @Autowired
    private CatalogRepository catalogRepository;



    @PostMapping(value = "create")
    public ResponseEntity<String> setLoan(@RequestBody Loan loan) {

        Loan lo = loanRepository.save(loan);
        String msg = "Loan created correctly";

        if (loan.getDateOut().equals(lo.getDateOut())) {
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }

        msg = "Loan couldn't be created";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }


    @GetMapping(value = "client/{id}")
    public ResponseEntity<List<LoanWithBookName>> getLoansByClientId2(@PathVariable("id") int id) {

        List<Loan> loans = loanRepository.getLoansByClientId(id);
        List<LoanWithBookName> response = new ArrayList<>();

        for (Loan l: loans) {
            LoanWithBookName loanWithBookName = new LoanWithBookName();
            loanWithBookName.setDateOut(l.getDateOut());
            loanWithBookName.setDateReturned(l.getDateReturned());
            loanWithBookName.setDateDue(l.getDateDue());
            Catalog catalog = catalogRepository.findById(l.getCatalogId()).orElse(null);
            if (catalog != null) {
                loanWithBookName.setTitle(catalog.getBook().getTitle());
                response.add(loanWithBookName);
            } else {
                return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NO_CONTENT);
            }

        }

        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
