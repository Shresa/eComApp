package com.ecommerce.ecomApp.service;

import com.ecommerce.ecomApp.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long CategoryId);

    Category updateCategory(Category category, Long categoryId);
}
