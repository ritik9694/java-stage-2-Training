package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	
	private Engine engine;
	
	public Car() {
		System.out.println("car :: constructor");
		
	}
	

	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public void startJourney() {
		boolean engineStatuts = engine.startEngine();
		
		if(engineStatuts)
			System.out.println("happy Journey");
		else
			System.out.println("Journey cancelled");
	}

}
