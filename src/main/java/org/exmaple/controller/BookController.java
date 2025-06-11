package org.exmaple.controller;

import org.exmaple.model.dto.Book;
import org.exmaple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
}
