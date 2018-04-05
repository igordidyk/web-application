package com.project.test.controller;

import com.project.test.entity.Authors;
import com.project.test.service.AuthorsService;
import com.project.test.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    @GetMapping("/showAuthors")
    public String showAuthors(Model model) {
        final List<Authors> showAuthors = new ArrayList<>();
        List<Authors> authorsList = authorsService.findAll();
        for (Authors author : authorsList) {
            int year = Integer.parseInt(author.getBorn().substring(0, 4));
            int currentYear = Calendar.getInstance().get(Calendar.YEAR);
            int age = currentYear - year;
            if (age >= 55) {
                System.out.println(author);
                showAuthors.add(author);
                System.out.println(showAuthors);
            }
            System.out.println(age);
        }
        model.addAttribute("showAuthors", showAuthors);
        return "index";
    }


}
