package com.example.sampletest.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sampletest.dto.AvailabilityRequestDTO;
import com.example.sampletest.model.Availability;

@Service
public class AvailabilityService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	List<Availability> availabilityList = new ArrayList<>();

	public Integer getAvailability(AvailabilityRequestDTO availRequestDTO) {

		initializeAvailabilityData();

		int currAvailability = 0;
		List<Availability> availabilityMatch = availabilityList.stream()
				.filter(a -> a.getStoreNo().compareTo(availRequestDTO.getStoreNo()) == 0
						&& sdf.format(availRequestDTO.getReqDate()).equals(sdf.format(a.getDate()))
						&& availRequestDTO.getProductId().compareTo(a.getProductId()) == 0)
				.collect(Collectors.toList());
		for (Availability a : availabilityMatch) {
			currAvailability += a.getAvailQty();
		}
		return currAvailability;
	}

	// to load availability data
	private void initializeAvailabilityData() {
		try {
			availabilityList.add(new Availability("Store001", "Prod1", sdf.parse("2021-02-19"), 1.0));
			availabilityList.add(new Availability("Store001", "Prod1", sdf.parse("2021-02-20"), 3.0));
			availabilityList.add(new Availability("Store001", "Prod1", sdf.parse("2021-02-21"), 0.0));

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
