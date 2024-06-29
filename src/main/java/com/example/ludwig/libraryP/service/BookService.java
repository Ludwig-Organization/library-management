package com.example.ludwig.libraryP.service;

import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Category;
import com.example.ludwig.libraryP.repo.BookRepo;
import com.example.ludwig.libraryP.repo.CateRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
    void addBook(Book book);
    List<Book> getAll();
    void deleteBookById(int id);
    Book getById(int id);
    void updateBook(Book book);
    List<Book> listBookStock(String name);
}
@Service
class BookServiceImp1 implements BookService{
    private final BookRepo bookRepo;
    private final CateRepo cateRepo;

    public BookServiceImp1(BookRepo bookRepo, CateRepo cateRepo) {
        this.bookRepo = bookRepo;
        this.cateRepo = cateRepo;
    }

    @Override
    @Transactional
    public void addBook(Book book) {

        Category category = cateRepo.findById(book.getCategory().getId()).orElse(null);
        book.setCategory(category);
        bookRepo.save(book);
    }
    @Override
    @Transactional
    public List<Book> getAll() {
        return bookRepo.findAll();
    }

    @Override
    @Transactional
    public Book getById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void deleteBookById(int id) {
        bookRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        bookRepo.save(book);
    }

    @Override
    @Transactional
    public List<Book> listBookStock(String name) {
       return bookRepo.findBookStockByName(name);
    }
}
