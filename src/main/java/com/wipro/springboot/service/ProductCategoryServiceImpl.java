package com.wipro.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.entity.ProductCategory;
import com.wipro.springboot.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements IProductCategoryService {

	@Autowired
	private ProductCategoryRepository categoryRepository;

	@Override
	public List<ProductCategory> getAllProductCategory() {
		return categoryRepository.findAll();
	}

}
