package com.example.library.controller;

import com.example.library.data.AuthorRepository;
import com.example.library.data.LanguageRepository;
import com.example.library.model.Author;
import com.example.library.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "api/language")
@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @RequestMapping(value = "all")
    public List<Language> getAllLanguage() {
        return languageRepository.findAll();
    }

    @RequestMapping(value = "{id}")
    public ResponseEntity<Language> getLanguage(@PathVariable int id) {

        Language la = languageRepository.findById(id).orElse(null);
        return new ResponseEntity<>(la, HttpStatus.OK);

    }

    @PostMapping(value = "create")
    public ResponseEntity<String> setLanguage(@RequestBody Language language) {

        Language la = languageRepository.save(language);
        String msg = "Language created correctly";

        if (language.getCode().equals(la.getCode())) {
            return new ResponseEntity<>(msg, HttpStatus.CREATED);
        }

        msg = "Language couldn't be created";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity<String> deleteLanguage(@PathVariable("id") int id) {

        Language la = languageRepository.findById(id).orElse(null);
        String msg = "Language deleted correctly";

        if (la != null) {

            try {

                languageRepository.delete(la);
                return new ResponseEntity<>(msg, HttpStatus.GONE);

            } catch (DataIntegrityViolationException e) {
                System.err.println(e.getMessage());
                msg = "Language couldn't be deleted. Please remove the books associated to this language first.";
                return new ResponseEntity<>(msg, HttpStatus.METHOD_NOT_ALLOWED);
            }

        }

        msg = "Language couldn't be deleted";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

    @PutMapping(value = "update")
    public ResponseEntity<String> updateLanguage(@RequestBody Language language) {

        Language la = languageRepository.findById(language.getId()).orElse(null);

        String msg = "Language don't exists";

        if (la == null) {
            return new ResponseEntity<>(msg, HttpStatus.OK);
        }

        languageRepository.save(language);
        msg = "Language updated";
        return new ResponseEntity<>(msg, HttpStatus.OK);

    }

}
