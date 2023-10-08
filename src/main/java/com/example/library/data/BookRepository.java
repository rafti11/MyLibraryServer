package com.example.library.data;

import com.example.library.model.BookDetails;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookDetails, Integer> {
}
