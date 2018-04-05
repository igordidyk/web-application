package com.project.test.controller;

import com.project.test.entity.Authors;
import com.project.test.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorsService authorsService;

    @PostMapping("/create")
    public String create(@RequestParam("name") String name,
                         @RequestParam("gender") String gender,
                         @RequestParam("born") String born) {
        try {
            Authors author = new Authors();
            System.out.println(encodeString(name));
            author.setName(encodeString(name));
            author.setGender(encodeString(gender));
            String bornDate = new SimpleDateFormat(born).format(new Date());
            author.setBorn(bornDate);
            System.out.println(author);
            authorsService.save(author);


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "redirect:/authors";
    }

    @GetMapping("/edit-{id}")
    public String edit(@PathVariable("id") int id,
                       Model model) {
        model.addAttribute("authorsInfo", authorsService.findOne(id));
        return "authors/authorEditing";
    }

    @GetMapping("/delete-{id}")
    public String delete(@PathVariable("id") int id) {
        authorsService.delete(id);
        return "redirect:/authors";
    }

    @PostMapping("/update")
    public String update(@RequestParam("id") int id,
                         @RequestParam("name") String name,
                         @RequestParam("gender") String gender,
                         @RequestParam("born") String born) {
        Authors author = authorsService.findOne(id);

        try {
            author.setName(encodeString(name));
            author.setGender(encodeString(gender));
            author.setBorn(encodeString(born));
            authorsService.update(author);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "redirect:/authors";
    }


    public String encodeString(String s) throws UnsupportedEncodingException {
        return new String(s.getBytes("ISO-8859-1"), "UTF-8");
    }
}
