package com.example.sampletest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sampletest.dto.AvailabilityRequestDTO;
import com.example.sampletest.model.Capacity;

@Service
public class CapacityService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	List<Capacity> capacityList = new ArrayList<>();

	public Integer getCapacity(AvailabilityRequestDTO availRequestDTO) {
		
		initializeCapacityData();
		
		int currCapacity = 0;

		List<Capacity> capacityMatch = capacityList.stream()
				.filter(a -> a.getStoreNo().compareTo(availRequestDTO.getStoreNo()) == 0
						&& sdf.format(availRequestDTO.getReqDate()).equals(sdf.format(a.getDate()))
						&& availRequestDTO.getProductId().compareTo(a.getProductId()) == 0)
				.collect(Collectors.toList());
		for (Capacity c : capacityMatch) {
			currCapacity += c.getNoOfOrdersAccepted();
		}
		return currCapacity;
	}

	// to load capacity data
	private void initializeCapacityData() {
		try {
			capacityList.add(new Capacity("Store001", "Prod1", sdf.parse("2021-02-19"), 0.0));
			capacityList.add(new Capacity("Store001", "Prod1", sdf.parse("2021-02-20"), 2.0));
			capacityList.add(new Capacity("Store001", "Prod1", sdf.parse("2021-02-21"), 2.0));
			capacityList.add(new Capacity("Store001", "Prod1", sdf.parse("2021-02-22"), 0.0));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
