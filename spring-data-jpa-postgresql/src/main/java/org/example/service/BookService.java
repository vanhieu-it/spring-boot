package org.example.service;

import org.example.repository.BookRepository;
import org.example.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }
    public Book save(Book book) {
        return bookRepository.save(book);
    }
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
    public List<Book> findByPublishedDateAfter(LocalDate date) {
        return bookRepository.findByPublishedDateAfter(date);
    }
}
