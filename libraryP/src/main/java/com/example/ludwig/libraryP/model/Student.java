package com.example.ludwig.libraryP.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
//Declare this when using @CreateBy and @CreateDate,
//@LastModifiedBy, @LastModifiedDate
@EntityListeners(EntityListeners.class)
//@Table(name = "student")
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    @Min(value = 18)
    private int age;
    @NotBlank
    private String address;
    @Pattern(regexp = "^0+[0-9]{9}$")
    private String phone;
    //Must declare AuditListener to automatically generate Date
    @CreatedDate
    private Date borrowDate;
    @Future
    private Date returnDate;
    @OneToMany(mappedBy = "student", cascade = CascadeType.MERGE)
    private List<Book> list = new ArrayList<>();
}
