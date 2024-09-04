package com.p10.Library_Management.repository;

import com.p10.Library_Management.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
