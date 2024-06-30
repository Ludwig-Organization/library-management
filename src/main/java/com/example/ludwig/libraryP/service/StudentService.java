package com.example.ludwig.libraryP.service;
import com.example.ludwig.libraryP.dto.BookDTO;
import com.example.ludwig.libraryP.dto.StudentDTO;
import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.BookManagement;
import com.example.ludwig.libraryP.model.Student;
import com.example.ludwig.libraryP.repo.BookRepo;
import com.example.ludwig.libraryP.repo.StudentRepo;

import java.util.*;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

public interface StudentService {
    void addStudent(Student student);

    Student findStudentById(int id);

    void updateStudent(Student student);

    Set<Book> getListBookByStudentID(int id);

    StudentDTO borrowBook(Student student);

}

@Service
class StudentServiceImp1 implements StudentService {
    private final StudentRepo studentRepo;
    private final BookRepo bookRepo;
    @Autowired
    public StudentServiceImp1(StudentRepo studentRepo, BookRepo bookRepo) {
        this.studentRepo = studentRepo;
        this.bookRepo = bookRepo;
    }
    @Override
    @Transactional
    public void addStudent(Student student) {
        studentRepo.save(student);
    }
    @Override
    @Transactional
    public Student findStudentById(int id) {
        Student student =  studentRepo.findById(id).orElse(null);
        return student;
    }
    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public Set<Book> getListBookByStudentID(int id) {
        Student student = studentRepo.findById(id).orElse(null);
        Set<Book> bookSet = new HashSet<>();
        bookSet.addAll(studentRepo.getBooksByStudentId(id));
        return bookSet;
    }
    @Override
    public StudentDTO borrowBook(Student student) { //list book contains only id of book
        Student studentDB = studentRepo.findById(student.getId()).orElse(null);
        //Handle list Books from input
        for (Book b : student.getList()){
            Book book = bookRepo.findById(b.getId()).orElse(null);
            if (book != null && book.isStatus() == true){
                book.setStatus(false);
                book.setStudent(studentDB);
            }
        }
        studentRepo.save(studentDB);
        //Convert student to studentDTO
        Set<Book> bookSet = getListBookByStudentID(student.getId());
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        for (Book b : bookSet){
          studentDTO.getBookMap().put(b.getId(), b.getName());
        }
        return studentDTO;
    }
}
