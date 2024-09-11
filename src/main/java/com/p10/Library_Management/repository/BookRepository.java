package com.p10.Library_Management.repository;

import com.p10.Library_Management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT b.quantity FROM Book b WHERE b.bookId=:bookId")
    Optional<Integer> getBookQuantity(@Param("bookId") Long bookId);
}
