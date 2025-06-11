package org.exmaple.service;

import org.exmaple.model.dto.Book;
import org.exmaple.model.entity.BookEntity;
import org.exmaple.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public void add(Book book){
        BookEntity bookEntity = new BookEntity();

        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());

        bookRepository.save(bookEntity);
    }
}
