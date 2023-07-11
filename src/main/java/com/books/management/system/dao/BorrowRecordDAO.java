package com.books.management.system.dao;

import com.books.management.system.entity.BorrowRecord;

import java.util.List;

public interface BorrowRecordDAO {
    BorrowRecord getBorrowRecordById(String recordId);
    List<BorrowRecord> getAllBorrowRecords();
    void addBorrowRecord(BorrowRecord borrowRecord);
    void updateBorrowRecord(BorrowRecord borrowRecord);
    void deleteBorrowRecord(String recordId);
    List<BorrowRecord> getBorrowRecordsByUserId(String userId);
}
