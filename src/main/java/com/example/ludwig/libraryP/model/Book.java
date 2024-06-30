package com.example.ludwig.libraryP.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "book")
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @NotBlank
    private String author;
    @NotBlank
    private String publisher;
    private boolean status;
    //RelationShip
    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonBackReference("category-books")
    private Category category;
    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference("student-books")
    private Student student;
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", status=" + status +
                ", category=" + category +
                ", student=" + student +
                '}';
    }
}
