package com.cts.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservices.model.Order;
import com.cts.microservices.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;

	@GetMapping("/product-id/{productId}/coupon-code/{couponCode}")
	public Order getOrder(@PathVariable long productId, @PathVariable String couponCode) {
		return service.getOrder(productId, couponCode);
	}
	
	
}
