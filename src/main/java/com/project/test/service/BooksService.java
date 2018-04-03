package com.project.test.service;

import com.project.test.entity.Books;
import java.util.List;

public interface BooksService {
    void insert(Books books);

    void update(Books books);

    void delete(int id);

    Books findOne(int id);

    List<Books> findAll();
}
