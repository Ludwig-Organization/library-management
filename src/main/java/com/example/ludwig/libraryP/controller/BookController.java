package com.example.ludwig.libraryP.controller;
import com.example.ludwig.libraryP.dto.BookDTO;
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
    private BookDTO addBook(@RequestBody Book book){
        return bookService.addBook(book);
    }
    @GetMapping("/list") //done
    public List<BookDTO> getAll(){
        return bookService.getAll();
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") int id){
        bookService.deleteBookById(id);
    }
    @GetMapping("/getById") //done
    public BookDTO getBookById(@RequestParam("id") int id){
        return bookService.getById(id);
    }
    @PutMapping("/edit")
    public BookDTO editNameById(@RequestBody Book book){
        bookService.updateBook(book);
        return bookService.getById(book.getId());
    }
    @GetMapping("/listAvailable")
    public List<BookDTO> listBookStock(@Param("name") String name){
        return bookService.listBookStock(name);
    }
}
