package com.example.booksmanagement.controller;

import com.example.booksmanagement.entity.Book;
import com.example.booksmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String home() {
        return "home.jsp";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("book", new Book());
        return "form.jsp";
    }

    @PostMapping("/form")
    public String addBook(Book book, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getAllErrors());
            return "form.jsp";
        }
        bookService.saveBook(book);
        return "confirm.jsp";
    }

    @GetMapping("/query/books")
    public String queryBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("path", "books");
        return "query.jsp";
    }

    @GetMapping("/books/edit/{id}")
    public String editBook(Model model, @PathVariable int id) {
        model.addAttribute("book", bookService.getBookById(id));
        return "form.jsp";
    }

    @PostMapping("/books/update")
    public String updateBook(Book book) {
        bookService.saveBook(book);
        return "redirect:/query/books";
    }
}
