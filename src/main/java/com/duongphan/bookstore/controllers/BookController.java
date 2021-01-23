package com.duongphan.bookstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {
    @GetMapping("/")
    public String index() {
       return "index";
    }

    @GetMapping("/booklist")
    public String bookList() {
        return "bookList";
    }
}
