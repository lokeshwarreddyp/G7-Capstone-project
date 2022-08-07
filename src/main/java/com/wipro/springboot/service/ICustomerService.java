package com.wipro.springboot.service;

import java.util.List;

import com.wipro.springboot.entity.Customer;

public interface ICustomerService {

	void save(Customer customer);

	List<Customer> getAllCustomers();

	void delete(Long id);
}
