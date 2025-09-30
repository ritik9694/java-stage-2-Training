package com.cognizant.boot.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {

	@Autowired
	@Qualifier("dieselEngine") //or set primary
	private Engine enginee;
	
	public void startJourney() {
		boolean engineStatus = enginee.startEngine();
		if(engineStatus)
			System.out.println("Happy Journey");
		else
			System.out.println("Journey cancelled");
	}
}
