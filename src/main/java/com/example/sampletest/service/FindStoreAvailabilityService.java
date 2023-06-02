package com.example.sampletest.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sampletest.dto.FindStoreAvailabilityRequestDTO;
import com.example.sampletest.dto.FindStoreAvailabilityResponseDTO;
import com.example.sampletest.model.Calender;

@Service
public class FindStoreAvailabilityService {

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

	List<Calender> calList = new ArrayList<>();

	Map<Integer, String> dayMap = new HashMap<Integer, String>();

	public FindStoreAvailabilityResponseDTO getStoreAvailability(
			FindStoreAvailabilityRequestDTO findStoreavailRequestDTO) {

		loadCalenderData();
		loadDayMap();


		Calender cal = calList.stream()
				.filter(a -> a.getStoreID().equalsIgnoreCase(findStoreavailRequestDTO.getStoreID()))
				.collect(Collectors.toList()).get(0);

		String reqHour = findStoreavailRequestDTO.getRequestDate().getHours()+"";
		int reqDay = findStoreavailRequestDTO.getRequestDate().getDay();

		String calDay = cal.getDay();
		String calCutOffTime = cal.getCutOffTime();
		

		String status = "";
		if (cal.getStoreID().equals("STORE001") && reqHour.compareTo(calCutOffTime)==1) {
			status = "Available";
		} else if (!cal.getStoreID().equals("STORE001") && calDay.equals(dayMap.get(reqDay))
				&& reqHour.compareTo(calCutOffTime)==-1) {
			status = "Available";
		} else {
			status = "Not Available";
		}

		FindStoreAvailabilityResponseDTO findStoreAvailResponseDTO = new FindStoreAvailabilityResponseDTO(
				findStoreavailRequestDTO.getStoreID(), findStoreavailRequestDTO.getRequestDate(), status);

		return findStoreAvailResponseDTO;

	}

	public void loadCalenderData() {

		calList.add(new Calender("STORE001", "ALL", "13:30"));
		calList.add(new Calender("STORE002", "SUNDAY", "13:30"));
		calList.add(new Calender("STORE003", "MONDAY", "13:30"));
	}

	public void loadDayMap() {
		dayMap.put(0, "SUNDAY");
		dayMap.put(1, "MONDAY");
		dayMap.put(2, "TUESDAY");
		dayMap.put(3, "WEDNESDAY");
		dayMap.put(4, "THURSDAY");
		dayMap.put(5, "FRIDAY");
		dayMap.put(6, "SATURDAY");
	}
}
