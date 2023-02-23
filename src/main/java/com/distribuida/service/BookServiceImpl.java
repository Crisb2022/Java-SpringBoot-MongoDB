package com.distribuida.service;

import com.distribuida.db.Book;
import com.distribuida.repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRespository bookRespository;

    @Override
    public List<Book> findAll() {
        return bookRespository.findAll();
    }

    @Override
    public Book findById(Integer id) {
        return bookRespository.findBookById(id);
    }

    @Override
    public Book createBook(Book book) {
        return bookRespository.save(book);
    }

    @Override
    public Book updateBook(Integer id,Book book) {
        Book upBook = bookRespository.findBookById(id);
        upBook.setPrice(book.getPrice());
        upBook.setTitle(book.getTitle());
        upBook.setIsbn(book.getIsbn());
        upBook.setAuthor(book.getAuthor());
        return bookRespository.save(upBook);
    }

    @Override
    public void deleteBook(Integer id) {
        bookRespository.deleteById(id);
    }
}
