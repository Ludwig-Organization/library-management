package com.example.ludwig.libraryP.repo;
import com.example.ludwig.libraryP.model.BookManagement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookManagementRepo extends JpaRepository<BookManagement, Integer> {
}
