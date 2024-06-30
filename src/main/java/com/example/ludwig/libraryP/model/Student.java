package com.example.ludwig.libraryP.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.ZonedDateTime;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
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
    @OneToMany(mappedBy = "student", cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JsonManagedReference("student-books")
    private Set<Book> list = new HashSet<>();
    @Override
    public String toString() {

        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", list=" + list +
                '}';
    }
}
