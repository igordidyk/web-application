package com.project.test.dao;

import com.project.test.entity.Authors;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorsDAO extends JpaRepository<Authors, Integer> {
}
