package com.wipro.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wipro.springboot.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
