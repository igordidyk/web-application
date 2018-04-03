package com.project.test.controller;

import com.project.test.service.AuthorsService;
import com.project.test.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/books")
public class BooksController {

    @GetMapping("/books")
    public String bookCreationPage() {
        return "books/bookEditing";
    }

}
