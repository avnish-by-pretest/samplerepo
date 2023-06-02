package com.example.sampletest.service;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.example.sampletest.model.ProductList;

@Service
public class ProductService {

	public ProductList sortProducts(ProductList productList) {
		Collections.sort(productList.getProductList(), (p1, p2) -> {
			return (p2.getProductId().compareTo(p1.getProductId())) != 0
					? p2.getProductId().compareTo(p1.getProductId())
					: p2.getLaunchDate().compareTo(p1.getLaunchDate());
		});
		return productList;
	}
}
