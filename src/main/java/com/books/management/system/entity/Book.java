package com.books.management.system.entity;

import javax.persistence.*;

@Entity
@Table(name = "Book")
public class Book {
    @Id
    @Column(name = "book_id")
    private String bookId;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "category")
    private String category;

    @Column(name = "quantity")
    private int quantity;
}
