package com.cts.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.microservices.model.Coupon;
import com.cts.microservices.model.Order;
import com.cts.microservices.model.Product;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;

@Service
public class OrderService {

	@Autowired
	RestTemplate rt;
	
	@HystrixCommand(fallbackMethod = "getProductFallback")
	public Product getProduct(long productId) {
		Product product=rt.getForObject("http://PRODUCT-SERVICE/products/product-id/"+productId, Product.class);
		
		return product;
	}
	
	
	public Product getProductFallback(long productId) {
		Product product=new Product(productId, "Phone", 10000);
		
		return product;
	}
	
	@HystrixCommand(fallbackMethod = "getCouponFallback")
	public Coupon getCoupon(String couponCode) {
		Coupon coupon=rt.getForObject("http://COUPON-SERVICE/coupons/coupon-code/"+couponCode, Coupon.class);
		
		return coupon;
	}
	
	public Coupon getCouponFallback(String couponCode) {
		Coupon coupon=new Coupon(couponCode, 50, 500, 5000);
		
		return coupon;
	}
	@HystrixCommand(fallbackMethod = "getOrderFallBack")
	public Order getOrder(long productId, String couponCode) {
		Product product=getProduct(productId);
		Coupon coupon=getCoupon(couponCode);
		double discount=0;
		if(product.getPrice()>=coupon.getMinAmount()) {
			discount=product.getPrice()*(coupon.getDiscount()/100);
			discount=discount>coupon.getMaxDiscount()?coupon.getMaxDiscount():discount;
		}
		double finalPrice=product.getPrice()-discount;
		Order order=new Order(product, coupon, discount, finalPrice);
		return order;
		
		
	}
	
	
	public Order getOrderFallBack(long productId, String couponCode) {
		Product product=new Product(productId, "Phone", 10000);
		Coupon coupon=new Coupon(couponCode, 50, 500, 5000);
		double discount=0;
		if(product.getPrice()>=coupon.getMinAmount()) {
			discount=product.getPrice()*(coupon.getDiscount()/100);
			discount=discount>coupon.getMaxDiscount()?coupon.getMaxDiscount():discount;
		}
		double finalPrice=product.getPrice()-discount;
		Order order=new Order(product, coupon, discount, finalPrice);
		return order;
		
		
	}
	
	
	
	
}
