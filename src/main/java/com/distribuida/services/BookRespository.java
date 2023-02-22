package com.distribuida.services;

import com.distribuida.db.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "book", path = "book")
public interface BookRespository extends MongoRepository<Book, Integer> {
    List<Book> findAll( );

    Optional<Book> findById(@Param("id") Integer id);

    void createBook(Book book);

    void updateBook( Book book);

    void deleteBook( Integer id );
}
