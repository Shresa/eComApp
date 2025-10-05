package com.ecommerce.ecomApp.service;

import com.ecommerce.ecomApp.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
                findFirst().orElse(null);
        if(cat==null) {
            return "No such Category found";
        }
        categories.remove(cat);
        return "Category with categoryId: " + CategoryId + " has been deleted";
    }
}
