package com.example.library.data;

import com.example.library.model.Book;
import com.example.library.model.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface LanguageRepository extends ListCrudRepository<Language, Integer> {
}
