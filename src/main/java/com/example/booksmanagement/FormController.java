package com.example.booksmanagement;

import com.example.booksmanagement.dao.AuthorRepo;
import com.example.booksmanagement.dao.BookRepo;
import com.example.booksmanagement.entity.Author;
import com.example.booksmanagement.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    AuthorRepo authorRepo;

    @RequestMapping("/")
    public String showForm() {
        return "form.jsp";
    }

    @RequestMapping("/addBook")
    public String addBook(String title, String author, int year) {
        Author contains = authorRepo.findByNameContainingIgnoreCase(author);
        Author authorEnt = contains != null ? contains : authorRepo.save(new Author(author));
        bookRepo.save(new Book(title, authorEnt, year));
        return "confirm.jsp";
    }
}
