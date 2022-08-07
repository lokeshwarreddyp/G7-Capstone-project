package com.wipro.springboot.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.springboot.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Page<Product> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);

	Page<Product> findByNameContaining(@RequestParam("name") String name, Pageable pageable);

}
