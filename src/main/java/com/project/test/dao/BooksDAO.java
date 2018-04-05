package com.project.test.dao;

import com.project.test.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksDAO extends JpaRepository<Books, Integer> {
    @Query(value = "from Books b join fetch b.authors")
    List<Books> findBooksWithAuthors();
}
