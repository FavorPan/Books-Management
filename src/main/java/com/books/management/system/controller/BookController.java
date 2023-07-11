package com.books.management.system.controller;

import com.books.management.system.entity.Book;
import com.books.management.system.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable String bookId) {
        Book book = bookService.findById(bookId);
        if (book != null) {
            return ResponseEntity.ok(book);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }
    @PostMapping("/create")
    public ResponseEntity<Void> createBook(@RequestBody Book book) {
        bookService.save(book);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping("/update/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable String bookId, @RequestBody Book book) {
        Book existingBook = bookService.findById(bookId);
        if (existingBook != null) {
            book.setBookId(bookId);
            bookService.update(book);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/delete/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable String bookId) {
        Book existingBook = bookService.findById(bookId);
        if (existingBook != null) {
            bookService.delete(bookId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/search/{keyword}")
    public List<Book> searchBooks(@PathVariable String keyword) {
        return bookService.searchBooks(keyword);
    }
}
