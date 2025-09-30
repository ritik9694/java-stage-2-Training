package com.cognizant.security.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.v3.oas.annotations.parameters.RequestBody;

   record Product(Integer productId, String productName) {};
@RestController
public class ProductController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	private static final List<Product> productList = new ArrayList<>(
			List.of(new Product(101, "Mobile"), new Product(102, "Computer"), new Product(103, "Laptop")));

	@GetMapping("/products")
	public List<Product> getAllProduct() {
		return productList;
	}

	@GetMapping("/products/{pid}")
	public Product getProductByProductId(@PathVariable Integer pid) {
		Product product = productList.stream().filter(prod -> prod.productId().equals(pid)).findFirst().orElse(null);
		return product;
	}

	@PostMapping("/products/new")
	public void addNewProduct(@RequestBody Product product) {
		productList.add(product);
		logger.info("saving new product{}", product);
	}
}
