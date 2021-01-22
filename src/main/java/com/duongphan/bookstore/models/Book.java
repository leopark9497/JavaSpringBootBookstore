package com.duongphan.bookstore.models;

public class Book {
    public String title;
    public String author;
    public int year;
    public String isbn;
    public float price;

    public Book(String title, String author, int year, String isbn, float price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.isbn = isbn;
        this.price = price;
    }
}
