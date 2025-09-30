package com.cognizant.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PocessingByCollect1 {

	public static void main(String[] args) {
		
		List<String> courseNames = Arrays.asList("Core Java", "Advanced Java", "Spring", "Spring Boot", "Microservices" , "React");
		System.out.println(courseNames);

		List<String> courseLengthWith9=courseNames.stream().filter(cName -> cName.length() > 8 )
		                    .collect(Collectors.toList());
		
		System.out.println(courseLengthWith9);
		
	}

}
