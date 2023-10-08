package com.example.library.data;

import com.example.library.model.Book;
import com.example.library.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Integer> {
}
