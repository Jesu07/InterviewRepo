package com.example.demo.service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.InvalidBookException;
import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Override
    public List<Book> getBooks(Integer id) throws BookNotFoundException {
        System.out.println(id);
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(1, "Fundamentals of Java", "Abc");
        bookList.add(book1);
        System.out.println(bookList);
        List<Book> response = new ArrayList<>();
        bookList.stream().forEach(book -> {
            if (book.getBookId().equals(id)) {
                response.add(book);
            } else {
                try {
                    throw new BookNotFoundException("Requested Book not found...");
                } catch (BookNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        System.out.println(response);
        return response;
    }

    @Override
    public List<Book> getBooks(String authorName) throws InvalidBookException {
        List<Book> bookList = new ArrayList<>();
        Book book1 = new Book(1, "Fundamentals of Java", "Abc");
        bookList.add(book1);
        List<Book> response = new ArrayList<>();
        bookList.stream().forEach(book -> {
            if (book.getAuthor().equals(authorName)) {
                response.add(book);
            } else {
                try {
                    throw new InvalidBookException("Requested Author details is invalid...");
                } catch (InvalidBookException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return response;
    }

}
