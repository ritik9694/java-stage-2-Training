package com.cognizant.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

// @SpringBootApplication

//@ComponentScan
//@Configuration
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(Application.class, args);
		System.out.println("=".repeat(100));
		
		int noOfBeans = context.getBeanDefinitionCount();
		System.out.println("no of beans = "+noOfBeans);
		System.out.println("=".repeat(100));
		System.out.println();
		
		String[] noOfBeansName =context.getBeanDefinitionNames();
		System.out.println("no of beans with name = " + noOfBeansName);
		System.out.println("=".repeat(100));
		System.out.println();
	}

}
