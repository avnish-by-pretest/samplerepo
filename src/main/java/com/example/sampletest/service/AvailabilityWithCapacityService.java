package com.example.sampletest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sampletest.dto.AvailabilityRequestDTO;
import com.example.sampletest.dto.AvailabilityResponseDTO;

@Service
public class AvailabilityWithCapacityService {

	@Autowired
	private AvailabilityService availabilityService;

	@Autowired
	private CapacityService capacityService;

	static int availability;
	static int capacity;

	public AvailabilityResponseDTO getProdAvailability(AvailabilityRequestDTO availRequestDTO) {

		int capacity = capacityService.getCapacity(availRequestDTO);
		int availability = availabilityService.getAvailability(availRequestDTO);

		//String status = availability == 0 ? null : capacity == 0 ? status = "No Capacity" : "Available";
		String status = "";


        if(availability==0)
            return null;
        else if(capacity==0)
            status = "No Capacity";
        else
            status = "Available";

		AvailabilityResponseDTO availResponseDTO = new AvailabilityResponseDTO(availRequestDTO.getStoreNo(),
				availRequestDTO.getProductId(), availRequestDTO.getReqDate(), availRequestDTO.getReqQty(), status);

		return availResponseDTO;

	}

}
