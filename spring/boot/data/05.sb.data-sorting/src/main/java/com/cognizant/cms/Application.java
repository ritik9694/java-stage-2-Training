package com.cognizant.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.model.Contact;
import com.cognizant.cms.service.ContactServiceImpl;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private ContactServiceImpl contactServiceImpl;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Contact> contacts=contactServiceImpl.getContactsInContactNameOrder();
		printContacts(contacts);
		
	}

	private void printContacts(List<Contact> contacts) {
		contacts.forEach(System.out::println);
		
	}

}
