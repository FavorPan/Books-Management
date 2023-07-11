package com.books.management.system.dao.impl;

import com.books.management.system.dao.BookDAO;
import com.books.management.system.entity.Book;
import com.books.management.system.mapper.BookRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book findById(String bookId) {
        String sql = "SELECT * FROM Book WHERE book_id = ?";
        return jdbcTemplate.queryForObject(sql, new BookRowMapper(), bookId);
    }

    @Override
    public List<Book> findAll() {
        String sql = "SELECT * FROM Book";
        return jdbcTemplate.query(sql, new BookRowMapper());
    }

    @Override
    public void save(Book book) {
        String sql = "INSERT INTO Book (book_id, title, author, category, quantity) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory(), book.getQuantity());
    }

    @Override
    public void update(Book book) {
        String sql = "UPDATE Book SET title = ?, author = ?, category = ?, quantity = ? WHERE book_id = ?";
        jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getCategory(), book.getQuantity(), book.getBookId());
    }

    @Override
    public void delete(String bookId) {
        String sql = "DELETE FROM Book WHERE book_id = ?";
        jdbcTemplate.update(sql, bookId);
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        String sql = "SELECT * FROM Book WHERE title LIKE ? OR author LIKE ?";
        String likeKeyword = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new BookRowMapper(), likeKeyword, likeKeyword);
    }
}
