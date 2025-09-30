package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Car {

	public Car() {
		System.out.println("Car :: Constructor");
	}
	
	public void startJourney() {
		boolean startStatuts = new Random().nextBoolean();
		
		if(startStatuts) {
			System.out.println("Happy Journey!!!");
		}else {
			System.err.println("Journey Cancelled!!");
		}
	}

}
