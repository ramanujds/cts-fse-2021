package com.cts.microservices.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.microservices.model.Coupon;

@FeignClient(value = "coupon-service", url = "http://localhost:5200/coupons")
public interface CouponServiceFeignClient {

	@GetMapping("/coupon-code/{couponCode}")
	Coupon getCoupon(@PathVariable("couponCode") String couponCode);
	
}
