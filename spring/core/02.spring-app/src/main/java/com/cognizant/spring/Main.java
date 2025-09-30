package com.cognizant.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.spring.core.beans.Users;

public class Main {

	public static void main(String[] args) {
		
		// initilize the spring conatiner
				// BeanFactory factory = new ClassPathXmlApplicationContext("user-bean.xml");
				ApplicationContext context = new ClassPathXmlApplicationContext("user-bean.xml");
				System.out.println("=".repeat(80));

				Users usr1 = (Users) context.getBean("user2");
				System.out.println(usr1); //toString()
				System.out.println("=".repeat(80));
				
				Users usr2 = context.getBean("user1", Users.class);
				System.out.println(usr2);
				System.out.println("-".repeat(80));
				
				Users usr3 = (Users) context.getBean("user1");
				System.out.println(usr3);
				System.out.println("-".repeat(80));	
				
				Users usr4 = (Users) context.getBean("user1");
				System.out.println(usr4);	
				System.out.println("-".repeat(80));	
				
				System.out.println(usr2.hashCode() + " | " + usr3.hashCode() + " | " + usr4.hashCode());

	}

}
