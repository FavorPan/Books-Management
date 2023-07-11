package com.books.management.system.controller;

import com.books.management.system.entity.BorrowRecord;
import com.books.management.system.service.BorrowRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrowRecords")
public class BorrowRecordController {
    private final BorrowRecordService borrowRecordService;
    @Autowired
    public BorrowRecordController(BorrowRecordService borrowRecordService) {
        this.borrowRecordService = borrowRecordService;
    }
    @GetMapping("/{recordId}")
    public BorrowRecord getBorrowRecordById(@PathVariable String recordId) {
        return borrowRecordService.getBorrowRecordById(recordId);
    }
    @GetMapping
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordService.getAllBorrowRecords();
    }
    @PostMapping("/create")
    public void addBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        borrowRecordService.addBorrowRecord(borrowRecord);
    }
    @PutMapping("/update")
    public void updateBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        borrowRecordService.updateBorrowRecord(borrowRecord);
    }
    @DeleteMapping("delete/{recordId}")
    public void deleteBorrowRecord(@PathVariable String recordId) {
        borrowRecordService.deleteBorrowRecord(recordId);
    }
    @GetMapping("/user/{userId}")
    public List<BorrowRecord> getBorrowRecordsByUserId(@PathVariable String userId) {
        return borrowRecordService.getBorrowRecordsByUserId(userId);
    }
}
