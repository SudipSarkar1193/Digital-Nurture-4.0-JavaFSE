package com.sudip.service;

import com.sudip.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;

    // Setter for dependency injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Example method to test the injected repository
    public void addBook(String bookTitle) {
        if (bookRepository != null) {
            bookRepository.save(bookTitle);
            System.out.println("Book '" + bookTitle + "' added successfully.");
        } else {
            System.out.println("BookRepository is not initialized.");
        }
    }
}