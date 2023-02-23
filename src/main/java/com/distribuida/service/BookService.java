package com.distribuida.service;

import com.distribuida.db.Book;

import java.util.List;


public interface BookService {
    List<Book> findAll();
    Book findById(Integer id);
    Book createBook(Book book);
    Book updateBook(Integer id, Book book);
    void deleteBook(Integer id);
}
