package com.example.booksmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @RequestMapping("/")
    public String showForm() {
        return "form.jsp";
    }

    @RequestMapping("/addBook")
    public String addBook(String title, String author) {
        System.out.println(title);
        String[] authors = author.split(",");
        for (String a : authors) {
            System.out.println(a.trim());
        }
        return "form.jsp";
    }
}
