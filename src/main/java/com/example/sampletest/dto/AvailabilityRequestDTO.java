package com.example.sampletest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailabilityRequestDTO {

	String storeNo;
	String productId;
	Date reqDate;
	Double reqQty;

}
