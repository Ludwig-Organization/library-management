
package com.example.ludwig.libraryP.repo;

import com.example.ludwig.libraryP.dto.CateDTO;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ludwig.libraryP.model.Category;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CateRepo extends JpaRepository<Category, Integer> {
//    @Query("SELECT new com.example.ludwig.libraryP.dto.CateDTO(c.id, c.cateName, c.bookList) from Category c")
//    public List<CateDTO> getListCate();
}

