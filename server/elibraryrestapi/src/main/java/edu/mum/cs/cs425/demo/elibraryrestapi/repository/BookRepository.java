package edu.mum.cs.cs425.demo.elibraryrestapi.repository;

import edu.mum.cs.cs425.demo.elibraryrestapi.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
