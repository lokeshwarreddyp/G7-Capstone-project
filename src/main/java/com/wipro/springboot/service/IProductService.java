package com.wipro.springboot.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.wipro.springboot.entity.Product;


public interface IProductService {

	List<Product> getAllProducts();
	
	Page<Product> getProductByCategory(Long id,Pageable pageable);

	Product getProduct(Long id);

	Page<Product> getProductByName(String name, Pageable pageable);

	Page<Product> getProductSortByPrice(String name,PageRequest request);

	void delete(Long id);

	void update(Product product);


}
