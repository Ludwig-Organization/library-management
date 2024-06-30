package com.example.ludwig.libraryP.service;

import com.example.ludwig.libraryP.dto.BookDTO;
import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.model.Category;
import com.example.ludwig.libraryP.model.Student;
import com.example.ludwig.libraryP.repo.BookRepo;
import com.example.ludwig.libraryP.repo.CateRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

public interface BookService {
    BookDTO addBook(Book book);
    List<BookDTO> getAll();
    void deleteBookById(int id);
    BookDTO getById(int id);
    void updateBook(Book book);
    List<BookDTO> listBookStock(String name);
}
@Service
class BookServiceImp1 implements BookService{
    private final BookRepo bookRepo;
    private final CateRepo cateRepo;
    @Autowired
    public BookServiceImp1(BookRepo bookRepo, CateRepo cateRepo) {
        this.bookRepo = bookRepo;
        this.cateRepo = cateRepo;
    }
    @Override
    @Transactional
    public BookDTO addBook(Book book) {
        BookDTO bookDTO = new BookDTO();
        Category category = cateRepo.findById(book.getCategory().getId()).orElse(null);
        if (category != null){
            book.setCategory(category);
            bookRepo.save(book);
            //response
            convertBookToDTONoCateNoStu(bookDTO,book);
            bookDTO.setCategory_id(category.getId());
        }else {
            bookDTO.setName("No category found!");
        }
        return bookDTO;
    }
    @Override
    @Transactional
    public List<BookDTO> getAll() {
        List<Book> bookList =  bookRepo.findAll();
        List<BookDTO> dtoList = new ArrayList<>();
        for(Book b : bookList){
            BookDTO bookDTO = new BookDTO();
            convertBookToDTONoCateNoStu(bookDTO, b);
            bookDTO.setCategory_id(b.getCategory().getId());
            dtoList.add(bookDTO);

        }
        return dtoList;
    }

    @Override
    @Transactional
    public BookDTO getById(int id) {
         Book book = bookRepo.findById(id).orElse(null);
         BookDTO bookDTO = new BookDTO();
         if (book != null){
             convertBookToDTONoCateNoStu(bookDTO, book);
             bookDTO.setCategory_id(book.getCategory().getId());
         }else {
             bookDTO.setName("No Book found!");
         }
         return bookDTO;
    }

    @Override
    @Transactional
    public void deleteBookById(int id) {
        bookRepo.deleteById(id);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        Book bookDB = bookRepo.findById(book.getId()).orElse(null);
        if (bookDB != null){
            bookRepo.save(book);
        }
    }
    @Override
    @Transactional
    public List<BookDTO> listBookStock(String name) {
       List<Book> bookList = bookRepo.findBookStockByName(name);
       List<BookDTO> dtoList = new ArrayList<>();
        for(Book b : bookList){
            BookDTO bookDTO = new BookDTO();
            convertBookToDTONoCateNoStu(bookDTO, b);
            bookDTO.setCategory_id(b.getCategory().getId());
            dtoList.add(bookDTO);
        }
        return dtoList;
    }
    private static BookDTO convertBookToDTONoCateNoStu(BookDTO bookDTO, Book book){
        //Map Book to BookDTO
        bookDTO.setId(book.getId());
        bookDTO.setName(book.getName());
        bookDTO.setStatus(book.isStatus());
        return bookDTO;
    }
}
