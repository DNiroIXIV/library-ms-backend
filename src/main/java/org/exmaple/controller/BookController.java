package org.exmaple.controller;

import org.exmaple.model.dto.Book;
import org.exmaple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Service
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public void add(@RequestBody Book book){
        bookService.add(book);
    }

    @GetMapping("/search-by-isbn/{isbn}")
    public Book searchByIsbn(@PathVariable Long isbn){
        return bookService.searchByIsbn(isbn);
    }

    @GetMapping("/get-all")
    public List<Book> getAll(){
        return bookService.getAll();
    }

    @PutMapping("/update")
    public void update(@RequestBody Book book){
        bookService.update(book);
    }
}
