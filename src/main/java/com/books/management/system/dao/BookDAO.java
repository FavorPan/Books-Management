package com.books.management.system.dao;

import com.books.management.system.entity.Book;
import java.util.List;

public interface BookDAO {
    Book findById(String bookId);
    List<Book> findAll();
    void save(Book book);
    void update(Book book);
    void delete(String bookId);
    List<Book> searchBooks(String keyword);
}
