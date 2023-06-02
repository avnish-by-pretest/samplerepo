package com.example.sampletest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	String productId;
	String productName;
	String unitOfMeasure;
	Date launchDate;

}
