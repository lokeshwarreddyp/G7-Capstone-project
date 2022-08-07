package com.wipro.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springboot.dto.Purchase;
import com.wipro.springboot.dto.PurchaseResponse;
import com.wipro.springboot.entity.Customer;
import com.wipro.springboot.entity.Order;
import com.wipro.springboot.entity.OrderItem;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements ICheckoutService {

	@Autowired
	private ICustomerService customerService;

	@Override
	@Transactional
	public PurchaseResponse placeOrder(Purchase purchase) {

		Order order = purchase.getOrder();

		String orderTrackingNumber = generateOrderTrackingNumber();
		order.setOrderTrackingNumber(orderTrackingNumber);

		Set<OrderItem> orderItems = purchase.getOrderItems();
		orderItems.forEach(item -> order.add(item));

		Customer customer = purchase.getCustomer();
		customer.add(order);

		customerService.save(customer);

		return new PurchaseResponse(orderTrackingNumber);
	}

	private String generateOrderTrackingNumber() {

		return UUID.randomUUID().toString();
	}
}
