package com.cognizant.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.Users;

public class Main {

	public static void main(String[] args) {
		
		// initilize the spring conatiner
				// BeanFactory factory = new ClassPathXmlApplicationContext("user-bean.xml");
				ApplicationContext context = new ClassPathXmlApplicationContext("user-bean.xml");
				System.out.println("=".repeat(80));

				((ConfigurableApplicationContext)context).close();

	}

}
