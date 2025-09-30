package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.cognizant.cms.model.Contact;
import com.cognizant.cms.repository.ContactRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		System.out.println();
		
		ContactRepository contactRepo =context.getBean(ContactRepository.class);
		
		/*
		 * ContactRepository is an interface - then how come instance/bean?
		 * - uses Proxy Design Pattern- implementation class is being created internally
		*/
		System.out.println("repository implementation class = " + contactRepo.getClass().getName());
		
		/*
		//--- save a contact
		Contact ct1 = new Contact();
		ct1.setContactId(101);
		ct1.setContactName("Sanjay Patil");
		ct1.setContactNumber("9848586878");
		
		//contactRepo.save(ct1);
		Contact savedContact = contactRepo.save(ct1);
		System.out.println("saved contact = " + savedContact);
		*/
		
		//-- save multiple contacts
		Contact ct1 = new Contact(107, "Ajnay", "857492596");
		Contact ct2 = new Contact(108, "rambhu", "9574968596");
		Contact ct3 = new Contact(109, "sohan", "6574968596");
		Contact ct4 = new Contact(110, "jha", "7574968596");
		Contact ct5 = new Contact(111, "Arya", "9874968596");
		
		List<Contact> contacts = Arrays.asList(ct1, ct2, ct3, ct4, ct5);
		
		contactRepo.saveAll(contacts);		
		
		
		
		context.close();
	}

}
