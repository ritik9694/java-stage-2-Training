package com.cognizant.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByTest {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("Anil","Suraj","Praveen","Sanjay","Suraj","Anil","Anil", "anil");
		
		Map<String,Long> nameByCount =names.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		
		nameByCount.forEach((key,value) -> System.out.println(String.format("%-10s : %d", key, value)));
	}

}
