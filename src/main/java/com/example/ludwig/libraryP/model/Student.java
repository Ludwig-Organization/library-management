package com.example.ludwig.libraryP.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.ZonedDateTime;
import java.util.*;

@Data
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
    @Pattern(regexp = "^0+[0-9]{9}$", message = "Please enter as pattern: 0xxx(10 digits)")
    private String phone;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP) //don't change type from bigger type to smaller, it will lose data
    private ZonedDateTime borrowDate;
    @Future(message = "Only future time applicable")
    @Temporal(TemporalType.TIMESTAMP)
    private ZonedDateTime returnDate;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private Set<Book> list = new HashSet<>();
}
