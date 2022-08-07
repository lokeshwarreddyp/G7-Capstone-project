package com.wipro.springboot.dto;

import lombok.Data;

import java.util.Set;

import com.wipro.springboot.entity.Customer;
import com.wipro.springboot.entity.Order;
import com.wipro.springboot.entity.OrderItem;

@Data
public class Purchase {

	private Customer customer;
	private Order order;
	private Set<OrderItem> orderItems;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	
	

}
