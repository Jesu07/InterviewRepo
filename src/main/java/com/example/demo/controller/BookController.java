package com.example.demo.controller;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.InvalidBookException;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    // Create a Spring Boot REST API that manages a list of books.
    // Implement custom exception handling for scenarios such as "Book not found" or "Invalid book details".
    // Return appropriate HTTP status codes and error messages.

    @Autowired
    BookService bookService;

    @GetMapping("/getBooksById")
    public ResponseEntity<?> getBookById(@RequestParam("id") Integer id) {
        try {
            System.out.println(id);
            List<Book> bookList = bookService.getBooks(id);
            return ResponseEntity.ok().body(bookList);
        } catch (BookNotFoundException e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book is not found");
        }
    }

    @GetMapping("/getBooksByAuthor")
    public ResponseEntity<?> getBookByAuthor(@RequestParam("authorName") String authorName) {
        try {
            List<Book> bookList = bookService.getBooks(authorName);
            return ResponseEntity.ok().body(bookList);
        } catch (InvalidBookException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book is invalid");
        }
    }


}
