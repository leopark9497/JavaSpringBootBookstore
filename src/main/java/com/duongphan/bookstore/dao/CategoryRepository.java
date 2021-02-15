package com.duongphan.bookstore.dao;

import com.duongphan.bookstore.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
