package com.wipro.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.springboot.entity.Product;
import com.wipro.springboot.repository.ProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}

	@Override
	public Page<Product> getProductByCategory(Long id, Pageable pageable) {
		return productRepository.findByCategoryId(id, pageable);
	}

	@Override
	public Page<Product> getProductByName(String name, Pageable pageable) {
		return productRepository.findByNameContaining(name, pageable);
	}

	@Override
	public Page<Product> getProductSortByPrice(String name, PageRequest request) {
		return productRepository.findByNameContaining(name, request);
	}

	@Override
	public void delete(Long id) {
		Product product = productRepository.findById(id).get();
		productRepository.delete(product);
	}

	@Override
	public void update(Product product) {
		productRepository.save(product);

	}

}
