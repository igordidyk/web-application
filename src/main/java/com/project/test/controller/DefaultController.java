package com.project.test.controller;

import com.project.test.entity.Authors;
import com.project.test.entity.Books;
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

    @GetMapping("/showBooks")
    public String showBooks(Model model) {
        final List<Books> selectedBooks = new ArrayList<>();
        List<Books> books = booksService.findBooksWithAuthors();
        for (Books book : books) {
            List<Authors> authors = book.getAuthors();
            for (Authors author : authors) {
                if (author.getBooks().size() > 1) {
                    selectedBooks.add(book);
                }
            }
        }
        model.addAttribute("selectedBooks", selectedBooks);

        return "index";
    }

    @GetMapping("/findAuthor")
    public String findAuthor(Model model) {
        Authors author2;
        int quantity = 0;
        List<Authors> authors = authorsService.findAll();
        if (authors != null && authors.size() != 0) {
            author2 = authors.get(0);
            for (Authors author : authors) {
                int size = author.getBooks().size();
                if (size > quantity) {
                    quantity = size;
                    author2 = author;
                }
            }
        } else {
            throw new NullPointerException("List authors is empty");
        }
        model.addAttribute("author", author2);
        return "index";
    }
}
