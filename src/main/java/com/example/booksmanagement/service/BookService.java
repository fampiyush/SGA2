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

    public Book getBookById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Transactional
    public void saveBook(Book book) {
        Author prevAuthor = null;
        if (book.getId() != 0) {
            prevAuthor = bookRepo.findById(book.getId()).orElse(null).getAuthor();
        }
        Author author = authorService.getOrCreateAuthor(book.getAuthorName());
        if (prevAuthor != null && prevAuthor != author && prevAuthor.getBooks().size() == 1) {
            authorService.deleteAuthor(prevAuthor);
        }
        book.setAuthor(author);
        Book b = bookRepo.save(book);
        author.addBook(b);
    }
}
