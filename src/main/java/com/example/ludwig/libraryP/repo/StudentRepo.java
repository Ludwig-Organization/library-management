
package com.example.ludwig.libraryP.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query(value = "SELECT b.* FROM Book b WHERE b.student_id = :id1",nativeQuery = true)
	List<Book> getListBookByStudentID(@Param("id1") int id);
}

