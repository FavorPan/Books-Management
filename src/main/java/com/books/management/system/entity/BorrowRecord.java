package com.books.management.system.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BorrowRecord")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private int recordId;

    @Column(name = "book_id")
    private String bookId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "borrow_date")
    private LocalDate borrowDate;

    @Column(name = "return_date")
    private LocalDate returnDate;
}
