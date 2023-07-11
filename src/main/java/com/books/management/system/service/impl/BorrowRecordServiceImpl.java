package com.books.management.system.service.impl;

import com.books.management.system.dao.BorrowRecordDAO;
import com.books.management.system.entity.BorrowRecord;
import com.books.management.system.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowRecordServiceImpl implements BorrowRecordService {
    private final BorrowRecordDAO borrowRecordDAO;
    @Autowired
    public BorrowRecordServiceImpl(BorrowRecordDAO borrowRecordDAO) {
        this.borrowRecordDAO = borrowRecordDAO;
    }
    @Override
    public BorrowRecord getBorrowRecordById(String recordId) {
        return borrowRecordDAO.getBorrowRecordById(recordId);
    }
    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordDAO.getAllBorrowRecords();
    }
    @Override
    public void addBorrowRecord(BorrowRecord borrowRecord) {
        borrowRecordDAO.addBorrowRecord(borrowRecord);
    }
    @Override
    public void updateBorrowRecord(BorrowRecord borrowRecord) {
        borrowRecordDAO.updateBorrowRecord(borrowRecord);
    }
    @Override
    public void deleteBorrowRecord(String recordId) {
        borrowRecordDAO.deleteBorrowRecord(recordId);
    }
    @Override
    public List<BorrowRecord> getBorrowRecordsByUserId(String userId) {
        return borrowRecordDAO.getBorrowRecordsByUserId(userId);
    }
}
