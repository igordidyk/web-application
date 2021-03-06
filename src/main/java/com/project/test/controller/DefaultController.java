package com.project.test.controller;

import com.project.test.entity.Authors;
import com.project.test.entity.Books;
import com.project.test.service.AuthorsService;
import com.project.test.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("booksList", booksService.findAll());
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
                showAuthors.add(author);
            }
        }
        model.addAttribute("showAuthors", showAuthors);
        return "index";
    }

    @GetMapping("/showBooks")
    public String showBooks(Model model) {
        List<Authors> all = authorsService.findAll();
        List<Books> selectedBooks = null;
        for (Authors authorsItem : all) {
            int count = authorsItem.getBooks().size();
            if (count > 1) {
                List<Books> books = authorsItem.getBooks();
                selectedBooks = books;
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

    @GetMapping("/calcBooks")
    public String calculateBooks(Model model, @RequestParam("bookByGenre") int booksId) {
        int quantityBooksByGenre = 0;
        for (Books book : booksService.findAll()) {
            if (book.getGenre().equals(booksService.findOne(booksId).getGenre())) {
                quantityBooksByGenre++;
            }
        }
        model.addAttribute("quantityBooksByGenre", quantityBooksByGenre);
        return "index";
    }
}
