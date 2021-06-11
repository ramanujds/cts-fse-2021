package com.cts.microservices.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservices.model.Coupon;
import com.cts.microservices.repository.CouponRepo;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/coupons")
public class CouponController {
	@Autowired
	CouponRepo repo;

	@GetMapping("/coupon-code/{couponCode}")
	public Coupon getCoupon(@PathVariable String couponCode, HttpServletRequest request) {
		String header=request.getHeader("auth");
		log.info(header);
		return repo.getCoupon(couponCode);
	}
	
	
	
}
