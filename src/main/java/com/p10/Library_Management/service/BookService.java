package com.p10.Library_Management.service;

import com.p10.Library_Management.dao.BookDAO;
import com.p10.Library_Management.entity.Book;
import com.p10.Library_Management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookDAO.save(book);
    }

    public List<Book> listBooks() {
        return bookDAO.findAll();
    }

    public Optional<Integer> getBookQuantity(Long BookId) {
        return bookRepository.getBookQuantity(BookId);
    }

    public Book updateQuantity(Long BookId, int quantity) {
        Optional<Book> book = bookDAO.findById(BookId);
        if (book.isPresent()) {
            book.get().setQuantity(quantity);
            return bookDAO.save(book.get());
        }
        return null;
    }

    public void deleteBook(Long BookId) {
        bookDAO.deleteById(BookId);
    }
}
