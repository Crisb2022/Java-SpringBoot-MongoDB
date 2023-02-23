package com.distribuida.repository;

import com.distribuida.db.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// No necesita implementación, solo una interfaz, y tiene CRUD
public interface BookRespository extends MongoRepository<Book, Integer> {
    Book findBookById(Integer id);
    List<Book> findAll();
}
