package com.wipro.springboot.service;

import com.wipro.springboot.dto.Purchase;
import com.wipro.springboot.dto.PurchaseResponse;

public interface ICheckoutService {

	PurchaseResponse placeOrder(Purchase purchase);
}
