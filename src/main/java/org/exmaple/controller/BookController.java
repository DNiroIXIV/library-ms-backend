package org.exmaple.controller;

import org.exmaple.model.dto.Book;
import org.exmaple.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
