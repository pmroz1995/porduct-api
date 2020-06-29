package com.example.sellions.controller;

import com.example.sellions.dao.entity.Category;
import com.example.sellions.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/sellions/categoryController")
public class CategoryController {

    private CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public Iterable<Category> getAllCategories(){
        return categoryService.findAll();
    }

    @PostMapping("/postCategory")
    public void addCategory(@RequestBody Category category){
        categoryService.save(category);
    }




}
