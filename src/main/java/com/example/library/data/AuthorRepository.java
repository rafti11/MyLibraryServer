package com.example.library.data;

import com.example.library.model.Author;
import com.example.library.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface AuthorRepository extends ListCrudRepository<Author, Integer> {
}
