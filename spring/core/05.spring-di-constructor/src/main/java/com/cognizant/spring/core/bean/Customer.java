package com.cognizant.spring.core.bean;

public class Customer {
	private String customerName;
	private Car car;
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	public Car getCar() {
		return car;
	}

	public Customer(String customerName, Car car) {
		super();
		this.customerName = customerName;
		this.car = car;
	}
	
	
	
}
