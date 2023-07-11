package com.books.management.system.service.impl;

import com.books.management.system.dao.BookDAO;
import com.books.management.system.entity.Book;
import com.books.management.system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private final BookDAO bookDAO;
    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    @Override
    public Book findById(String bookId) {
        return bookDAO.findById(bookId);
    }
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }
    @Override
    public void save(Book book) {
        bookDAO.save(book);
    }
    @Override
    public void update(Book book) {
        bookDAO.update(book);
    }
    @Override
    public void delete(String bookId) {
        bookDAO.delete(bookId);
    }
    @Override
    public  List<Book> searchBooks(String keyword) { return bookDAO.searchBooks(keyword); }
}
