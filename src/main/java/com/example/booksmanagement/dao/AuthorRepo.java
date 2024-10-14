package com.example.booksmanagement.dao;

import com.example.booksmanagement.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Integer> {
    Author findByNameContainingIgnoreCase(String author);
}
