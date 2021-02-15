package com.duongphan.bookstore.services;

import com.duongphan.bookstore.dao.CategoryRepository;
import com.duongphan.bookstore.models.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> listAll() {
        return (List<Category>) repository.findAll();
    }
    public void save(Category category) {
        repository.save(category);
    }
    public Category get(long id) {
        return repository.findById(id).get();
    }
}
