package com.example.ludwig.libraryP.service;
import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Student;
import com.example.ludwig.libraryP.repo.StudentRepo;
import java.util.List;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

public interface StudentService {
    void addStudent(Student student);

    Student findStudentById(int id);

    void updateStudent(Student student);

    List<Book> getListBook(int id);
}

@Service
class StudentServiceImp1 implements StudentService {
    private final StudentRepo studentRepo;
    @Autowired
    public StudentServiceImp1(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }
    @Override
    @Transactional
    public void addStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    @Transactional
    public Student findStudentById(int id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentRepo.save(student);
    }

    @Override
    public List<Book> getListBook(int id) {
        return studentRepo.getListBookByStudentID(id);
    }

}
