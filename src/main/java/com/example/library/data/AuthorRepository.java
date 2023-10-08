package com.example.library.data;

import com.example.library.model.Author;
import com.example.library.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
