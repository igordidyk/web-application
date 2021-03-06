package com.project.test.controller;

import com.project.test.entity.Authors;
import com.project.test.entity.Books;
import com.project.test.service.AuthorsService;
import com.project.test.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/books")
public class BooksController {
    @Autowired
    private AuthorsService authorsService;
    @Autowired
    private BooksService booksService;

    @PostMapping("/create")
    public String create(@RequestParam("authorOfBook") List<Integer> listAuthorsId,
                         @RequestParam("name") String name,
                         @RequestParam("published") String published,
                         @RequestParam("genre") String genre,
                         @RequestParam("rating") String rating) {

        try {
            List<Authors> authorsList = new ArrayList<>();
            Books book = new Books();
            book.setName(encodeString(name));
            book.setPublished(encodeString(new SimpleDateFormat(published).format(new Date())));
            book.setGenre(encodeString(genre));
            book.setRating(encodeString(rating));
            for (Integer integer : listAuthorsId) {
                Authors author = authorsService.findOne(integer);
                authorsList.add(author);
            }
            book.setAuthors(authorsList);
            booksService.save(book);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "redirect:/books";
    }

    @GetMapping("/delete-{id}")
    public String delete(@PathVariable("id") int id) {
        booksService.delete(id);
        return "redirect:/books";
    }

    @GetMapping("/edit-{id}")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("booksInfo", booksService.findOne(id));
        return "books/bookEditing";
    }

    @PostMapping("/update")
    public String update(@RequestParam("name") String name,
                         @RequestParam("published") String published,
                         @RequestParam("genre") String genre,
                         @RequestParam("rating") String rating,
                         @RequestParam("id") int booksId) {
        try {

            Books book = booksService.findOne(booksId);
            book.setName(encodeString(name));
            book.setPublished(encodeString(published));
            book.setGenre(encodeString(genre));
            book.setRating(encodeString(rating));
            booksService.save(book);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }



        return "redirect:/books";
    }

    public String encodeString(String s) throws UnsupportedEncodingException {
        return new String(s.getBytes("ISO-8859-1"), "UTF-8");
    }

}
