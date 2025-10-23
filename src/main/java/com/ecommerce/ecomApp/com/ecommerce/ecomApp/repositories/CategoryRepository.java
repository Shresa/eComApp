package com.ecommerce.ecomApp.com.ecommerce.ecomApp.repositories;

import com.ecommerce.ecomApp.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
