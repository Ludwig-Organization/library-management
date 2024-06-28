package com.example.ludwig.libraryP.controller;

import com.example.ludwig.libraryP.model.Category;
import com.example.ludwig.libraryP.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cate")
public class CateController {
    private final CategoryService categoryService;
    @Autowired
    public CateController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("/add")
    public void addCate(@RequestBody @Valid Category category){
        categoryService.addCate(category);
    }
    @PostMapping("/edit")
    public void updateCate(@RequestBody @Validated() Category category){
        categoryService.updateCate(category);
    }
    @GetMapping("/list")
    public List<Category> listCate(){
        return categoryService.listCate();
    }
}
