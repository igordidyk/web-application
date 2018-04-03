package com.project.test.service.impl;

import com.project.test.dao.AuthorsDAO;
import com.project.test.entity.Authors;
import com.project.test.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuthorsServiceImpl implements AuthorsService {
    @Autowired
    private AuthorsDAO authorsDAO;

    @Override
    @Transactional
    public void save(Authors authors) {
        authorsDAO.save(authors);
    }

    @Override
    @Transactional
    public void update(Authors authors) {
        authorsDAO.save(authors);
    }

    @Override
    @Transactional
    public void delete(int id) {
        authorsDAO.delete(id);
    }

    @Override
    public Authors findOne(int id) {
        return authorsDAO.findOne(id);
    }


    @Override
    public List<Authors> findAll() {
        return authorsDAO.findAll();
    }
}
