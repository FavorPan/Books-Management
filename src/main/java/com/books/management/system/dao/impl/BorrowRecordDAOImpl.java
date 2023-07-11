package com.books.management.system.dao.impl;

import com.books.management.system.dao.BorrowRecordDAO;
import com.books.management.system.entity.BorrowRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BorrowRecordDAOImpl implements BorrowRecordDAO {
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public BorrowRecordDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BorrowRecord getBorrowRecordById(String recordId) {
        String sql = "SELECT * FROM BorrowRecord WHERE record_id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(BorrowRecord.class), recordId);
    }
    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        String sql = "SELECT * FROM BorrowRecord";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecord.class));
    }
    @Override
    public void addBorrowRecord(BorrowRecord borrowRecord) {
        String sql = "INSERT INTO BorrowRecord (book_id, user_id, borrow_date, return_date) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, borrowRecord.getBookId(), borrowRecord.getUserId(), borrowRecord.getBorrowDate(), borrowRecord.getReturnDate());
    }
    @Override
    public void updateBorrowRecord(BorrowRecord borrowRecord) {
        String sql = "UPDATE BorrowRecord SET book_id = ?, user_id = ?, borrow_date = ?, return_date = ? WHERE record_id = ?";
        jdbcTemplate.update(sql, borrowRecord.getBookId(), borrowRecord.getUserId(), borrowRecord.getBorrowDate(), borrowRecord.getReturnDate(), borrowRecord.getRecordId());
    }
    @Override
    public void deleteBorrowRecord(String recordId) {
        String sql = "DELETE FROM BorrowRecord WHERE record_id = ?";
        jdbcTemplate.update(sql, recordId);
    }
    @Override
    public List<BorrowRecord> getBorrowRecordsByUserId(String userId) {
        String sql = "SELECT * FROM BorrowRecord WHERE user_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(BorrowRecord.class), userId);
    }
}
