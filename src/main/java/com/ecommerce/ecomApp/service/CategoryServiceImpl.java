package com.ecommerce.ecomApp.service;

import com.ecommerce.ecomApp.model.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    public List<Category> categories = new ArrayList<>();

    public List<Category> getAllCategories() {
        return categories;
    }
    public void createCategory(Category category){
        categories.add(category);
    }
    public String deleteCategory(Long CategoryId){
        Category cat = categories.stream().
                        filter(c->c.getCategoryId().equals(CategoryId)).
                findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No such Category found"));
        categories.remove(cat);
        return "Category with categoryId: " + CategoryId + " has been deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Optional<Category> categoryOpt = categories.stream().
                filter(c->c.getCategoryId().equals(categoryId)).
                findFirst();
        if(categoryOpt.isPresent()) {
            Category cat = categoryOpt.get();
            cat.setCategoryType(category.getCategoryType());
            return cat;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No such Category found");
        }
    }
}
