package com.example.ludwig.libraryP.repo;

import com.example.ludwig.libraryP.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Integer> {
    //Note: status: 1-OK, 0-NG
    @Query(nativeQuery = true, name = "select * from book where status = 1 and name like %:name%")
    List<Book> findBookStockByName(@Param("name") String name);
}
