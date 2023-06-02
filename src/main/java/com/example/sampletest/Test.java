package com.example.sampletest;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "13.30";
		
		int a = 15;
		
		Double i = Double.parseDouble(str);
		
		if(a<Double.parseDouble(str)) {
			System.out.println("Greater"+ i);
		} else {
			System.out.println("Small"+ i);
		}
		
		
		
	}

}
