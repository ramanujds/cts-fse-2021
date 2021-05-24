package com.cts.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cts.microservices.model.Coupon;
import com.cts.microservices.model.Order;
import com.cts.microservices.model.Product;

@Service
public class OrderService {

	@Autowired
	RestTemplate rt;
	
	public Product getProduct(long productId) {
		Product product=rt.getForObject("http://PRODUCT-SERVICE/products/product-id/"+productId, Product.class);
		
		return product;
	}
	
	public Coupon getCoupon(String couponCode) {
		Coupon coupon=rt.getForObject("http://COUPON-SERVICE/coupons/coupon-code/"+couponCode, Coupon.class);
		
		return coupon;
	}
	
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
	
	
	
	
}
