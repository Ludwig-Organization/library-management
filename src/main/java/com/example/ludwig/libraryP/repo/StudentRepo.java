
package com.example.ludwig.libraryP.repo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("select b from Book b where b.student.id = :id")
    Set<Book> getBooksByStudentId(@Param("id") int id);

}

