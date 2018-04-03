package com.project.test.dao;

import com.project.test.entity.Books;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BooksDAO extends JpaRepository<Books, Integer> {
}
