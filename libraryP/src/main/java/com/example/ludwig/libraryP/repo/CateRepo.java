
package com.example.ludwig.libraryP.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ludwig.libraryP.model.Category;

public interface CateRepo extends JpaRepository<Category, Integer> {

}

