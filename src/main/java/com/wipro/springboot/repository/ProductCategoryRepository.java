package com.wipro.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.wipro.springboot.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
}
