package com.example.booksmanagement.controller;

import com.example.booksmanagement.entity.Book;
import com.example.booksmanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
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
}
