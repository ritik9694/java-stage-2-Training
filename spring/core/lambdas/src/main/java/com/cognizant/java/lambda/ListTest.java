package com.cognizant.java.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("ritik","rahul","sanjeev","divyansh");
		System.out.println(names);
		System.out.println();
		
		/*Comparator<String> compRef =new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				int n = o1.compareTo(o2);
				if(n > 0)
				   return 1;
				return -1;
			}
		}; */
		
		
		///Lambda expresiion
		
		/*
		 * Comparator<String> compRef = (o1,o2) -> { int n = o1.compareTo(o2); if(n > 0)
		 * return 1; return -1; };
		 */
		
		Comparator<String> compRef = (o1,o2) -> o1.compareTo(o2) > 0 ? 1 : -1;
		
		names.sort(compRef);
		System.out.println(names);
	}

}
