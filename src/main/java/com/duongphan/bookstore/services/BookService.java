package com.duongphan.bookstore.services;

import com.duongphan.bookstore.dao.BookRepository;
import com.duongphan.bookstore.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> listAll() {
        return (List<Book>) repository.findAll();
    }

    public void save(Book book) {
        repository.save(book);
    }

    public Book get(long id) {
        return repository.findById(id).get();
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
