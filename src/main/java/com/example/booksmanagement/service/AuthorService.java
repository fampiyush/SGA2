package com.example.booksmanagement.service;

import com.example.booksmanagement.dao.AuthorRepo;
import com.example.booksmanagement.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepo authorRepo;

    public Author getOrCreateAuthor(String author) {
        Author contains = authorRepo.findByNameIgnoreCase(author);
        return contains != null ? contains : authorRepo.save(new Author(author));
    }

    public List<Author> getAllAuthors() {
        return authorRepo.findAll();
    }

    public void deleteAuthor(Author previousAuthor) {
        authorRepo.delete(previousAuthor);
    }

    public Author getAuthorById(int i) {
        return authorRepo.findById(i).orElse(null);
    }
}
