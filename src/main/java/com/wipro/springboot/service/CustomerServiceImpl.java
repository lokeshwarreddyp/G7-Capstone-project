package com.wipro.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.entity.Customer;
import com.wipro.springboot.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void save(Customer customer) {
		this.customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		 Customer customer = customerRepository.findById(id).get();
		 customerRepository.delete(customer);
	}
}
