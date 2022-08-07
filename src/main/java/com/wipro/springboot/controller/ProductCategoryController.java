package com.wipro.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.entity.ProductCategory;
import com.wipro.springboot.service.IProductCategoryService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("api/")
public class ProductCategoryController {

	@Autowired
	private IProductCategoryService categoryService;

	@GetMapping("product-category")
	public List<ProductCategory> getAllProductsCategory() {
		return categoryService.getAllProductCategory();
	}
	
	
	
	

}
