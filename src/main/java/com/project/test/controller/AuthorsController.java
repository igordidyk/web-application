package com.project.test.controller;

import com.project.test.entity.Authors;
import com.project.test.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @PostMapping("/create")
    public String create(@RequestParam("name") String name, @RequestParam("gender") String gender, @RequestParam("born") String born) {
        Authors author = new Authors();
        author.setName(name);
        author.setGender(gender);
        String bornDate = new SimpleDateFormat(born).format(new Date());
        author.setBorn(bornDate);
        authorsService.save(author);
        return "redirect:/authors";
    }

    @GetMapping("/edit-{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("authorsInfo", authorsService.findOne(id));
        return "authors/authorEditing";
    }


}
