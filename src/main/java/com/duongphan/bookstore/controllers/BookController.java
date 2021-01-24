package com.duongphan.bookstore.controllers;

import com.duongphan.bookstore.models.Book;
import com.duongphan.bookstore.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping("/")
    public String index() {
       return "index";
    }

    @GetMapping("/booklist")
    public String bookList(
            @RequestParam(required = false) String action,
            @RequestParam(required = false) String author,
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String isbn,
            @RequestParam(required = false) String year,
            @RequestParam(required = false) Long id,
            Model model
    ) {
        if (action != null) {
            if (action.equals("add_new_book")) {
                Book newBook = new Book(title, author, year, isbn);
                service.save(newBook);
            }

            if (action.equals("update_book")) {
                Book updatingBook = service.get(id);
                updatingBook.setAuthor(author);
                updatingBook.setTitle(title);
                updatingBook.setYear(year);
                updatingBook.setIsbn(isbn);
                service.save(updatingBook);
            }
        }

        List<Book> listOfBooks = service.listAll();
        model.addAttribute("listOfBooks", listOfBooks);

        return "bookList";
    }
}
