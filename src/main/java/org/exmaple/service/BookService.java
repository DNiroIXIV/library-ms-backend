package org.exmaple.service;

import org.exmaple.model.dto.Book;
import org.exmaple.model.entity.BookEntity;
import org.exmaple.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    
    public Book searchByIsbn(Long isbn){
        Optional<BookEntity> instanceById = bookRepository.findById(isbn);

        if(instanceById.isPresent()){
            BookEntity bookEntity = instanceById.get();

            Book book = new Book();
            book.setIsbn(bookEntity.getIsbn());
            book.setTitle(bookEntity.getTitle());
            book.setAuthor(bookEntity.getAuthor());

            return book;
        }
        return null;
    }

    public List<Book> getAll() {
        List<BookEntity> bookEntityList = bookRepository.findAll();

        List<Book> bookList = new ArrayList<>();

        bookEntityList.forEach(bookEntity -> {
            Book book = new Book();
            book.setIsbn(bookEntity.getIsbn());
            book.setTitle(bookEntity.getTitle());
            book.setAuthor(bookEntity.getAuthor());
            bookList.add(book);
        });
        return bookList;
    }

    public void update(Book book) {
        BookEntity bookEntity = new BookEntity();
        bookEntity.setIsbn(book.getIsbn());
        bookEntity.setTitle(book.getTitle());
        bookEntity.setAuthor(book.getAuthor());

        bookRepository.save(bookEntity);
    }
}
