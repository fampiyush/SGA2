package com.example.booksmanagement.service;

import com.example.booksmanagement.dao.AuthorRepo;
import com.example.booksmanagement.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public Author getOrCreateAuthor(String author) {
        Author contains = authorRepo.findByNameContainingIgnoreCase(author);
        return contains != null ? contains : authorRepo.save(new Author(author));
    }
}
