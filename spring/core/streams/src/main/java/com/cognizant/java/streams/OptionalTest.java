package com.cognizant.java.streams;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		
		String[] name = new String[10];
		
		Optional<String> opt = Optional.empty();
		System.out.println(opt);
		System.out.println(opt.isEmpty());
		System.out.println(opt.isPresent());
		
		opt = Optional.of("Cognizant");
		System.out.println(opt);
		System.out.println(opt.isEmpty());
		System.out.println(opt.isPresent());
		if(opt.isEmpty()) {
			String str = opt.get();
			System.out.println(str);
		}
	}

}
