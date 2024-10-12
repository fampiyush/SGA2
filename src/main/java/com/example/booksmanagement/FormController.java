package com.example.booksmanagement;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FormController {

    @RequestMapping("/")
    public String showForm() {
        return "form.jsp";
    }
}
