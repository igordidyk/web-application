package com.project.test.controller;

import com.project.test.service.AuthorsService;
import com.project.test.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {
    @Autowired
    private AuthorsService authorsService;
    @Autowired
    private BooksService booksService;

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
        model.addAttribute("authorsList", authorsService.findAll());
        model.addAttribute("booksList", booksService.findAll());
        return "books/booksPage";
    }
}
