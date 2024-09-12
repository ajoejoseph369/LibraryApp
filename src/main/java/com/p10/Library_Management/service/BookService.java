package com.p10.Library_Management.service;

import com.p10.Library_Management.dao.BookDAO;
import com.p10.Library_Management.dto.BookDTO;
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

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = mapToEntity(bookDTO); //convert dto to entity type
        Book savedBook = bookDAO.save(book); //save entity to db
        return mapToDTO(savedBook); //convert entity back to DTO
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

    private BookDTO mapToDTO(Book book) {
        return new BookDTO(book.getBookId(),book.getBookName(),book.getAuthor(),book.getQuantity());
    }

    private Book mapToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookId(bookDTO.getId());
        book.setBookName(bookDTO.getBookName());
        book.setAuthor(bookDTO.getAuthor());
        book.setQuantity(bookDTO.getQuantity());
        return book;
    }
}
