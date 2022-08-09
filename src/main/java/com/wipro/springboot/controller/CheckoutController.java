package com.wipro.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wipro.springboot.dto.Purchase;
import com.wipro.springboot.dto.PurchaseResponse;
import com.wipro.springboot.service.ICheckoutService;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/checkout")
public class CheckoutController {

	@Autowired
	private ICheckoutService checkoutService;

	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {

		PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);

		return purchaseResponse;
	}

}
