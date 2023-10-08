package com.example.library.data;

import com.example.library.model.BookDetails;
import com.example.library.model.Shelf;
import org.springframework.data.repository.CrudRepository;

public interface ShelfRepository extends CrudRepository<Shelf, Integer> {
}
