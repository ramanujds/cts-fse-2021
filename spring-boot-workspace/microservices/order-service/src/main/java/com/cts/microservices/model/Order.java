package com.cts.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	private Product product;
	private Coupon coupon;
	
	private double discountApplied;
	private double finalPrice;
	
}
