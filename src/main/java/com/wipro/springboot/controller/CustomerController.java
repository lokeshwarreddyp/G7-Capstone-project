package com.wipro.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.springboot.entity.Customer;
import com.wipro.springboot.service.ICustomerService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private ICustomerService customerService;
	
	@GetMapping("/admin/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@DeleteMapping("/admin/customer/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		customerService.delete(id);
		return ResponseEntity.ok("Customer Deleted");
	}
}
