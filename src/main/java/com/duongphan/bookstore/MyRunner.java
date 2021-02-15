package com.duongphan.bookstore;

import com.duongphan.bookstore.dao.CategoryRepository;
import com.duongphan.bookstore.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private CategoryRepository repository;

    @Override
    public void run(String... args) {
        repository.save(new Category("Tech"));
        repository.save(new Category("Drama"));
        repository.save(new Category("Horror"));
    }
}
