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
    public Long lastId = 1L;
    @GetMapping("/api/public/categories")
    public List<Category> getAllCategories() {
        return serv.getAllCategories();
    }

    @PostMapping("/api/public/categories")
    public String createCategory(@RequestBody Category category) {
        category.setCategoryId(lastId++);
        serv.createCategory(category);
        return "new category added";
    }

    @DeleteMapping("/api/admin/categories/{categoryId}")
    public String deleteCategory(@PathVariable Long categoryId) {
        return serv.deleteCategory(categoryId);
    }

}
