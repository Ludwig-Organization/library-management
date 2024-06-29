package com.example.ludwig.libraryP.controller;
import com.example.ludwig.libraryP.model.Book;
import com.example.ludwig.libraryP.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @PostMapping("/add")
    private void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }
    @GetMapping("/list")
    public List<Book> getAll(){
        return bookService.getAll();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        bookService.deleteBookById(id);
    }
    @GetMapping("/getById")
    public Book getBookById(@RequestParam("id") int id){
        return bookService.getById(id);
    }
    @PutMapping("/edit")
    public Book editNameById(@RequestBody Book book){
        bookService.updateBook(book);
        return bookService.getById(book.getId());
    }
    @GetMapping("/listAvailable")
    public List<Book> listBookStock(@Param("name") String name){
        return bookService.listBookStock(name);
    }
}
