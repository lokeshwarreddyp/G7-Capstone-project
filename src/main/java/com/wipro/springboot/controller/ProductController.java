package com.wipro.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.entity.Product;
import com.wipro.springboot.service.IProductService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private IProductService productService;

	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return productService.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productService.getProduct(id);
	}

	@PostMapping("/admin/product/new")
	public ResponseEntity<String> post(@RequestBody Product product) {
		productService.update(product);
		return ResponseEntity.ok("Product Posted");
	}

	@DeleteMapping("/admin/product/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		productService.delete(id);
	}

	@PutMapping("/admin/product/edit/{id}")
	public ResponseEntity<String> edit(@PathVariable("id") Long id, @RequestBody Product product) {
		productService.update(product);
		return ResponseEntity.ok("Product Updated");
	}

	@GetMapping("products/search/findByCategoryId/{id}")
	public Page<Product> getProductByCategory(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "3") Integer size, @PathVariable("id") Long id) {
		PageRequest request = PageRequest.of(page, size);
		return productService.getProductByCategory(id, request);
	}

	@GetMapping("products/search/findByCategoryId/sortByPrice/{id}")
	public Page<Product> getProductByCategoryBySort(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "3") Integer size, @PathVariable("id") Long id) {
		PageRequest request = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "unitPrice"));
		return productService.getProductByCategory(id, request);
	}

	@GetMapping("products/search/findByNameContaining/{name}")
	public Page<Product> getProductByName(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "3") Integer size, @PathVariable("name") String name) {
		PageRequest request = PageRequest.of(page, size);
		return productService.getProductByName(name, request);
	}

	@GetMapping("products/search/findByNameContaining/sortByPrice/{name}")
	public Page<Product> getProductSortByPrice(@RequestParam(value = "page", defaultValue = "1") Integer page,
			@RequestParam(value = "size", defaultValue = "3") Integer size, @PathVariable("name") String name) {
		PageRequest request = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "unitPrice"));
		return productService.getProductSortByPrice(name, request);
	}
}
