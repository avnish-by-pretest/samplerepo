package com.example.sampletest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sampletest.model.ProductList;
import com.example.sampletest.service.ProductService;

@RestController
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/sortProducts")
	public ResponseEntity sortProducts(@RequestBody ProductList productList) {
		ProductList sortedProducts = productService.sortProducts(productList);
		return ResponseEntity.status(HttpStatus.OK).body(sortedProducts);
	}
}
