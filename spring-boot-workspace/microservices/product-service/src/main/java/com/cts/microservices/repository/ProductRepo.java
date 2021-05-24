package com.cts.microservices.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.cts.microservices.model.Product;

@Repository
public class ProductRepo {

	Map<Long, Product> products;
	
	@PostConstruct
	public void init() {
		Product p1=new Product(10001, "Samsung Phone", 20000.0);
		Product p2=new Product(10002, "Macbook", 90000.0);
		Product p3=new Product(10003, "Alexa", 4000.0);
		
		products=new HashMap<Long, Product>();
		
		products.put(p1.getProductId(), p1);
		products.put(p2.getProductId(), p2);
		products.put(p3.getProductId(), p3);
		
	}
	
	public Product getProductById(long productId) {
		return products.get(productId);
	}
	
}
