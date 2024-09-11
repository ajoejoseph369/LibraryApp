package com.p10.Library_Management.controller;

import com.p10.Library_Management.service.BookService;
import com.p10.Library_Management.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/findAll")
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @GetMapping("getQuantity/{bookID}")
    public ResponseEntity<Integer> getBookQuantity(@PathVariable Long bookID) {
        return bookService.getBookQuantity(bookID)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/changeQty/{bookID}")
    public ResponseEntity<Book> changeQuantity(@PathVariable Long bookID, @RequestParam int quantity) {
        Book updatedBook = bookService.updateQuantity(bookID, quantity);
        if(updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("delete/{bookID}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookID) {
        bookService.deleteBook(bookID);
        return ResponseEntity.noContent().build();
    }

}
