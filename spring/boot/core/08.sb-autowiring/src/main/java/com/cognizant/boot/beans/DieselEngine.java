package com.cognizant.boot.beans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine {

	public DieselEngine() {
		System.out.println("Diesel :: constructor");
		
	}
	
 @Override
public boolean startEngine() {
	 System.out.println("starting enine with diesel");
		boolean engineStatus = new Random().nextBoolean();
		return engineStatus;
}
}
