package com.example.demo.service;

import com.example.demo.exception.BookNotFoundException;
import com.example.demo.exception.InvalidBookException;
import com.example.demo.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks(Integer id) throws BookNotFoundException;

    List<Book> getBooks(String authorName) throws InvalidBookException;

}
