package com.p10.Library_Management.controller;

import com.p10.Library_Management.BookService;
import com.p10.Library_Management.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/create")
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/findall")
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

}
