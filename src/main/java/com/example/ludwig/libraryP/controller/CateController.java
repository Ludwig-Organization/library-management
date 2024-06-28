package com.example.ludwig.libraryP.controller;
import com.example.ludwig.libraryP.dto.CateDTO;
import com.example.ludwig.libraryP.model.Category;
import com.example.ludwig.libraryP.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping("/{id}")
    public CateDTO getCateById(@PathVariable("id") int id){
        return categoryService.getCateById(id);
    }
    @PostMapping("/edit-name")
    public CateDTO updateName(@RequestBody Category category){
        return categoryService.updateCate(category);
    }
    @GetMapping("/list")
    public List<CateDTO> listCate(){
        return categoryService.listCate();
    }
}
