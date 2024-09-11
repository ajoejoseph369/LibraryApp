package com.p10.Library_Management.dao;

import com.p10.Library_Management.entity.Book;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface BookDAO {
    Book save(Book book);
    List<Book> findAll();
    Optional<Book> findById(Long bookId);
    void deleteById(Long BookId);

}
