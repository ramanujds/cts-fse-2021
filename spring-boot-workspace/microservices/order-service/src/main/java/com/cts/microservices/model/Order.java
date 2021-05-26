package com.cts.microservices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author ramanujdas
 *
 */
public class Order {
	
	private Product product;
	private Coupon coupon;
	
	private double discountApplied;
	private double finalPrice;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Coupon getCoupon() {
		return coupon;
	}
	public void setCoupon(Coupon coupon) {
		this.coupon = coupon;
	}
	public double getDiscountApplied() {
		return discountApplied;
	}
	public void setDiscountApplied(double discountApplied) {
		this.discountApplied = discountApplied;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public Order(Product product, Coupon coupon, double discountApplied, double finalPrice) {
		super();
		this.product = product;
		this.coupon = coupon;
		this.discountApplied = discountApplied;
		this.finalPrice = finalPrice;
	}
	
	public Order() {
		// TODO Auto-generated constructor stub
	}
	
	
}
