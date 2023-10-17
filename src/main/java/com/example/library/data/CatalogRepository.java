package com.example.library.data;

import com.example.library.model.Catalog;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface CatalogRepository extends ListCrudRepository<Catalog, Integer> {
}
