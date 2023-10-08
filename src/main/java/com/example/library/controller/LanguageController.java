package com.example.library.controller;

import com.example.library.data.AuthorRepository;
import com.example.library.data.LanguageRepository;
import com.example.library.model.Author;
import com.example.library.model.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LanguageController {

    @Autowired
    private LanguageRepository languageRepository;

    @RequestMapping(value = "language/all")
    public Iterable<Language> getAllLanguage() {
        return languageRepository.findAll();
    }


    @RequestMapping(value = "language/create")
    public void setLanguage(@RequestBody Language language) {

        languageRepository.save(language);

    }


}
