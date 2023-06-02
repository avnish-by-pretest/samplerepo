package com.example.sampletest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityResponseDTO {

	String storeNo;
	String productId;
	Date reqDate;
	Double reqQty;
	String status;

}
