package com.project.test.service.impl;

import com.project.test.dao.BooksDAO;
import com.project.test.entity.Books;
import com.project.test.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksDAO booksDAO;

    @Override
    @Transactional
    public void save(Books books) {
        booksDAO.save(books);
    }

    @Override
    @Transactional
    public void update(Books books) {
        booksDAO.save(books);
    }

    @Override
    @Transactional
    public void delete(int id) {
        booksDAO.delete(id);
    }

    @Override
    public Books findOne(int id) {
        return booksDAO.findOne(id);
    }

    @Override
    public List<Books> findAll() {
        return booksDAO.findAll();
    }
}
