package com.ecommerce.ecomApp.service;

import com.ecommerce.ecomApp.com.ecommerce.ecomApp.repositories.CategoryRepository;
import com.ecommerce.ecomApp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
//    public List<Category> categories = new ArrayList<>();

    public Long lastId = 1L;
    @Autowired
    private CategoryRepository categoryRepository;
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    public void createCategory(Category category){
//        category.setCategoryId(lastId++);
        categoryRepository.save(category);
//        categories.add(category);
    }
    public String deleteCategory(Long CategoryId){
        Category cat = categoryRepository.findById(CategoryId).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No such Category found"));
//        List<Category> categories = categoryRepository.findAll();
//        Category cat = categories.stream().
//                        filter(c->c.getCategoryId().equals(CategoryId)).
//                findFirst().orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No such Category found"));
        categoryRepository.delete(cat);
        return "Category with categoryId: " + CategoryId + " has been deleted";
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        Category cat = categoryRepository.findById(categoryId).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"No such Category found"));
        category.setCategoryId(categoryId);
        cat = categoryRepository.save(category);
        return cat;
//        List<Category> categories = categoryRepository.findAll();
//        Optional<Category> categoryOpt = categories.stream().
//                filter(c->c.getCategoryId().equals(categoryId)).
//                findFirst();
//        if(categoryOpt.isPresent()) {
//            Category cat = categoryOpt.get();
//            cat.setCategoryType(category.getCategoryType());
//            return categoryRepository.save(cat);
//        } else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No such Category found");
//        }
    }
}
