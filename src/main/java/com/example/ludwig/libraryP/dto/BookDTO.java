package com.example.ludwig.libraryP.dto;
import com.example.ludwig.libraryP.model.Category;
import com.example.ludwig.libraryP.model.Student;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class BookDTO {
    @NotNull
    private int id;
    private String name;
    private boolean status;
    private int category_id;
    private int student_id;
}
