package com.cts.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Coupon {

	private String couponCode;
	private double discount;
	private double maxDiscount;
	private double minAmount;
	
	public Coupon() {
		// TODO Auto-generated constructor stub
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public double getMaxDiscount() {
		return maxDiscount;
	}

	public void setMaxDiscount(double maxDiscount) {
		this.maxDiscount = maxDiscount;
	}

	public double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}

	public Coupon(String couponCode, double discount, double maxDiscount, double minAmount) {
		super();
		this.couponCode = couponCode;
		this.discount = discount;
		this.maxDiscount = maxDiscount;
		this.minAmount = minAmount;
	}
	
	
	
}
