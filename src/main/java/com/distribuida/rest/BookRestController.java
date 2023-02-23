package com.distribuida.rest;

import com.distribuida.db.Book;
import com.distribuida.dto.BookDTO;
import com.distribuida.service.BookService;
import com.distribuida.service.BookServiceImpl;
import com.distribuida.util.ObjectMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/")
    public List<BookDTO> getAllBooks(){
        return ObjectMapperUtil.mapAll(bookService.findAll(), BookDTO.class);
    }

    @GetMapping(value = "/byId/{id}")
    public BookDTO getById(@PathVariable("id")Integer id){
        return ObjectMapperUtil.map(bookService.findById(id), BookDTO.class);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> createBook(@RequestBody BookDTO bookDTO){
        bookService.createBook(ObjectMapperUtil.map(bookDTO, Book.class));
        return new ResponseEntity("Agregado correctamente", HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> updateBook(@PathVariable("id") Integer id,@RequestBody BookDTO bookDTO){
        bookService.updateBook(id,ObjectMapperUtil.map(bookDTO, Book.class));
        return new ResponseEntity("Agregado correctamente", HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer id){
        bookService.deleteBook(bookService.findById(id).getId());
        return new ResponseEntity("Eliminado correctamente", HttpStatus.OK);
    }
}
