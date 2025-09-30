package com.cognizant.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlatMapTest {

	public static void main(String[] args) {
		
		List<List<String>> list = new ArrayList<>();
		
		list.add(Arrays.asList("a","b","c"));
		list.add(Arrays.asList("d","e","f","a"));
		list.add(Arrays.asList("g","h","i"));
		list.add(Arrays.asList("j","k","a", "l"));
		
		List<String> mappedList = list.stream()
				                              .flatMap(st -> st.stream())
				                              .collect(Collectors.toList());
		System.out.println(mappedList);
		System.out.println();
		
		//to upper case
		List<String> mappedList2 = list.stream()
				                      .flatMap(str -> str.stream())
				                      .map(st -> st.toUpperCase())
				                      .collect(Collectors.toList());
		System.out.println(mappedList2);
		System.out.println();
		
		//--apply flatMap to apply a filter to get only "a"
		
		List<String> mappedList3 = list.stream()
				                    .flatMap(str -> str.stream()
				                    		.filter(st -> st.equalsIgnoreCase("A")))
				                    .collect(Collectors.toList());
		System.out.println(mappedList3);
		System.out.println();
				                    
	}

}
