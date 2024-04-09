package org.example.controller;

import org.example.model.Book;
import org.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public List<Book> findAll() {
        return bookService.findAll();
    }

    @GetMapping("/find/title/{title}")
    public List<Book> findByTitle(String title) {
        return bookService.findByTitle(title);
    }
    @GetMapping("/find/date-after/{date}")
    public List<Book> findByPublishedDateAfter(LocalDate date) {
        return bookService.findByPublishedDateAfter(date);
    }
    @GetMapping("/{id}")
    public Optional<Book> findById(Long id) {
        return bookService.findById(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Book create(Book book) {
        return bookService.save(book);
    }
    @PutMapping
    public Book update(Book book) {
        return bookService.save(book);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }
}
