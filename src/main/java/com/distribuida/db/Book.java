package com.distribuida.db;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Book") // Es como entity en JPA
public class Book implements Serializable {
    @Id
    private Integer id;
    private String isbn;
    private String title;
    private String author;
    private Double price;



}