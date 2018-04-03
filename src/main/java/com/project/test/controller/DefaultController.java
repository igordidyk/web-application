package com.project.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/authors")
    public String authorsPage(Model model) {
        return "authors/authorsPage";
    }
}
