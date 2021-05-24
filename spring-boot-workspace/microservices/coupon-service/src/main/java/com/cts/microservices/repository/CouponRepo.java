package com.cts.microservices.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.cts.microservices.model.Coupon;

@Repository
public class CouponRepo {

	private Map<String, Coupon> coupons;
	
	@PostConstruct
	public void init() {
		Coupon c1=new Coupon("c1001", 15.0, 500.0, 5000);
		Coupon c2=new Coupon("c1002", 25.0, 1000.0, 25000);
		Coupon c3=new Coupon("c1003", 20.0, 1500.0, 30000);
		coupons=new HashMap<>();
		coupons.put(c1.getCouponCode(), c1);
		coupons.put(c3.getCouponCode(), c3);
		coupons.put(c2.getCouponCode(), c2);
		
	}
	
	
	public Coupon getCoupon(String couponCode) {
		return coupons.get(couponCode);	
		
	}
	
}
