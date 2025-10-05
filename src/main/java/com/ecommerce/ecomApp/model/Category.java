package com.ecommerce.ecomApp.model;

public class Category {
    private Long categoryId;
    private String categoryType;

    public Category(Long categoryId, String categoryType) {
        this.categoryId = categoryId;
        this.categoryType = categoryType;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }
}
