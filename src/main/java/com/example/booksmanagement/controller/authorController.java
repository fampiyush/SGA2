package com.example.booksmanagement.controller;

import com.example.booksmanagement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class authorController {
    @Autowired
    private AuthorService authorService;

    @GetMapping("query/authors")
    public String queryAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        model.addAttribute("path", "authors");
        return "query.jsp";
    }
}
