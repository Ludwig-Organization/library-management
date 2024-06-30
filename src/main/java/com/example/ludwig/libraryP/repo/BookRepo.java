package com.example.ludwig.libraryP.repo;

import com.example.ludwig.libraryP.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface BookRepo extends JpaRepository<Book, Integer> {
    //Note: status: true - OK, false - NG
    @Query("select b from Book b where b.status = true and b.name like %:name%")
    Set<Book> findBookStockByName(@Param("name") String name);
}
