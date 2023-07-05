package com.books.management.system.service;

import com.books.management.system.entity.Book;

import java.util.List;

public interface BookService {
    Book findById(String bookId);
    List<Book> findAll();
    void save(Book book);
    void update(Book book);
    void delete(String bookId);
}
