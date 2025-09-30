package com.cognizant.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.bean.User;



public class Main {

	public static void main(String[] args) {
     ApplicationContext context = new ClassPathXmlApplicationContext("user-beans.xml");
		
		User usrs1 = (User)context.getBean("user1");
		System.out.println("usrs1");
		System.out.println();
		
		User usrs2 = (User) context.getBean("user2");
		System.out.println(usrs2);

	}

}
