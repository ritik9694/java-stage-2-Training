package com.cognizant.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.bean.Customer;

public class Main {

	public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("customer-car-bean.xml");
		
		Customer cust = (Customer)context.getBean("ritik");
		
		String custDetails = String.format("%s owns a %s car, which costs Rs. %.2f", cust.getCustomerName(), cust.getCar().getModel(), cust.getCar().getCost());
		System.out.println(custDetails);

	}

}
