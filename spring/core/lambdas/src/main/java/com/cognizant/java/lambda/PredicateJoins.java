package com.cognizant.java.lambda;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PredicateJoins {
	
	/*static void filterNums(Predicate<Integer>p, int [] nums) {
		for(int n : nums) {
			if(p.test(n)) {
				System.out.print(n+" ");
			}
		}
		System.out.println();
	}
	*/

	public static void main(String[] args) {
		
		/*
		int [] nums = {0,6,4,24,52,64,25,64,76};
		
		Predicate<Integer> p1 = n -> n > 10;
		Predicate<Integer> p2 = n -> n%2 == 0;
		
		System.out.println("original Number : " + Arrays.toString(nums));
         
		System.out.print("numbers greater than 10 : ");
		filterNums(p1, nums);
		
		System.out.print("Even number : ");
		filterNums(p2, nums);
		
		System.out.print("numbers not greater than 10 : ");
		filterNums(p1.negate(), nums);
		
		System.out.print("numbers greater than 10 and even : ");
		filterNums(p1.and(p2), nums);
		
		*/
		
		/*
		
		int nums = 25;
		
		Predicate<Integer> evenPredicate = n -> n%2 == 0;
		
		boolean evenStatus = evenPredicate.test(nums);
		if(evenStatus) {
			System.out.println(nums+ " is Even");
		}else {
			System.out.println(nums+ " is not Even");
		}
		
		*/
		
		/*
		 * 
		 * List<Integer> nums = Arrays.asList(11,12,13,14,15,16,17,18,19,20);
		 * System.out.println(nums);
		 * 
		 * Stream<Integer> numsStream = nums.stream(); Stream<Integer> numsStram1 =
		 * numsStream.filter(num -> num%2 == 0); List<Integer> evenNums =
		 * numsStram1.collect(Collectors.toList());
		 * 
		 * System.out.println(evenNums);
		 * 
		 */
		
		
		Predicate<Integer> p1 = n -> n > 10;
		int num =11;
		System.out.println(num + " is > 10 = " + p1.test(num));
		
		Predicate<String> p2 = (n) -> (n.length() > 4);
		
		String data = "cognizant";
		System.out.println("is \""+data+"\" length is > 4 = " + p2.test(data));
		
		Predicate<Collection> p3 = col -> col.isEmpty();
		
		List<String> names = Arrays.asList("ritik");
		System.out.println("is collection Empty = " + p3.test(names));
		
	}

}
