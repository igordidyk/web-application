package com.project.test.service;


import com.project.test.entity.Authors;
import java.util.List;

public interface AuthorsService {
    void save(Authors authors);

    void update(Authors authors);

    void delete(int id);

    Authors findOne(int id);

    List<Authors> findAll();
}
