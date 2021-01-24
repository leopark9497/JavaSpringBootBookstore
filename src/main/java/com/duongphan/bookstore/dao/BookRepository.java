package com.duongphan.bookstore.dao;

import com.duongphan.bookstore.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
