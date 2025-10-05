package com.ecommerce.ecomApp.controller;

import com.ecommerce.ecomApp.model.Category;
import com.ecommerce.ecomApp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    public CategoryService serv;
    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return serv.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category) {
        serv.createCategory(category);
        return "new category added";
    }

}
