package com.p10.Library_Management.service;

import com.p10.Library_Management.entity.Book;
import com.p10.Library_Management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookQuantity(Long BookId) {
        return bookRepository.findById(BookId);
    }

    public Book updateQuantity(Long BookId, int quantity) {
        Optional<Book> book = bookRepository.findById(BookId);
        if (book.isPresent()) {
            book.get().setQuantity(quantity);
            return bookRepository.save(book.get());
        }
        return null;
    }

    public void deleteBook(Long BookId) {
        bookRepository.deleteById(BookId);
    }
}
