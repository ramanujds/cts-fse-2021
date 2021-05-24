package com.cts.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

	private String couponCode;
	private double discount;
	private double maxDiscount;
	private double minAmount;
	
}
