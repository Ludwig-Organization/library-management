package com.example.ludwig.libraryP.controller;
import com.example.ludwig.libraryP.dto.StudentDTO;
import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Student;
import com.example.ludwig.libraryP.service.StudentService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/add") //done
    private Student addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        System.out.println("Student controller: Show student id when adding student "+student.getId());
        return student;
    }

    @GetMapping("/getStudentById") //done
    public Student getStudentById(@RequestParam("id") int id){
        return studentService.findStudentById(id);
    }

    @PutMapping("/edit")
    public void editById(@RequestBody Student student){
        studentService.updateStudent(student);
    }

    @GetMapping("/getListBookByStudentID") //done
    public Set<Book> getListBookByStudentId(@RequestParam("id") int id){
        return studentService.getListBookByStudentID(id);
    }

    @PutMapping("/borrowBook")
    public StudentDTO borrowBook(@RequestBody Student student){
        return studentService.borrowBook(student);
    }
}
