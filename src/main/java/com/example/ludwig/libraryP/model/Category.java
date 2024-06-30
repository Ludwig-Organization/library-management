package com.example.ludwig.libraryP.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Not Blank")
    private String cateName;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JsonManagedReference("category-books")
    private List<Book> bookList = new ArrayList<>();
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cateName='" + cateName + '\'' +
                ", bookList=" + bookList +
                '}';
    }
}
