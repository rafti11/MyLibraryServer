package com.example.library.data;

import com.example.library.model.Book;
import com.example.library.model.Loan;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface LoanRepository extends ListCrudRepository<Loan, Integer> {

    @Query(value = "SELECT * FROM loan WHERE cod_client = ?1", nativeQuery = true)
    List<Loan> getLoansByClientId(int id);


}
