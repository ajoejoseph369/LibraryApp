package com.p10.Library_Management.dao;

import com.p10.Library_Management.entity.Book;
import com.p10.Library_Management.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookDAOImpl implements BookDAO{

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override


}
