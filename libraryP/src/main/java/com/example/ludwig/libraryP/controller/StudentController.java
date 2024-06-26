package com.example.ludwig.libraryP.controller;

import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Student;
import com.example.ludwig.libraryP.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @PostMapping("/add")
    private void addStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }
    @GetMapping("/getById")
    public Student getStudentById(@RequestParam("id") int id){
        return studentService.findStudentById(id);
    }
    @PutMapping("/edit")
    public void editById(@RequestBody Student student){
        studentService.updateStudent(student);
    }
    @GetMapping("/getListBook")
    public List<Book> getListBookByStudentId(@RequestParam("id") int id){
        return studentService.getListBook(id);
    }
}