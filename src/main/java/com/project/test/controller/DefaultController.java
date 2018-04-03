package com.project.test.controller;

import com.project.test.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @Autowired
    private AuthorsService authorsService;

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        model.addAttribute("authorsList", authorsService.findAll());
        return "authors/authorsPage";
    }
    @GetMapping("/books")
    public String booksPage(Model model) {
        return "books/booksPage";
    }
}
