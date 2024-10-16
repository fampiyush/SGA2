package com.example.booksmanagement.service;

import com.example.booksmanagement.dao.BookRepo;
import com.example.booksmanagement.entity.Author;
import com.example.booksmanagement.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private AuthorService authorService;

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @Transactional
    public void saveBook(Book book) {
        Author author = authorService.getOrCreateAuthor(book.getAuthorName());
        book.setAuthor(author);
        bookRepo.save(book);
    }
}
