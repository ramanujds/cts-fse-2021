package com.cts.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.microservices.model.Product;
import com.cts.microservices.repository.ProductRepo;



@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	ProductRepo repo;

	@GetMapping("/product-id/{productId}")
	public Product getProduct(@PathVariable long productId) {
		return repo.getProductById(productId);
	}
	
	
	
}
