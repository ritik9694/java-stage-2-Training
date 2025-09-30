package com.cognizant.cms;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.cms.model.Contact;
import com.cognizant.cms.repository.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

	// @Autowired
	private ContactRepository contactRepositry;

	@Autowired
	public Application(ContactRepository contactRepositry) {
		this.contactRepositry = contactRepositry;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// ----- get the number of contacts -----
		Long countContact = contactRepositry.count();
		System.out.println("no of contact = " + countContact);
		System.out.println();

		// ----- check whether a contact is existing with a contactId or not
		int cid = 106;
		boolean isExist = contactRepositry.existsById(cid);
		System.out.println("contact by id : " + cid + " Is exist: " + isExist);

		// ----- get a Contact based on contactId( ID property value)
		Optional<Contact> optContact = contactRepositry.findById(cid);
		if (optContact.isPresent()) {
			Contact ct = optContact.get();
			System.out.println(ct);
		} else {
			System.err.println("Contact not found for ID: " + cid);
		}
		System.out.println();

		//Find all by id
				List<Integer> contacts1 = Arrays.asList(2,3);
				Iterable<Contact> contacts2 =  contactRepositry.findAllById(contacts1);
				System.out.println("By Find all by id we get :");
				System.out.println(contacts2);
				
		// -- ----- to get all contacts -----
		Iterable<Contact> findAllContact = contactRepositry.findAll();

		for (Contact contact : findAllContact) {
			System.out.println(contact);
		}

		// -- ----- delete a contact -----

		int contactId = 106; 
		if (isExist) {
			contactRepositry.deleteById(contactId);
			System.out.println("Contact deleted successfully.");
		} else {
			System.err.println("Contact not found for ID: " + contactId);
		}

		// -- ----- to delete all contacts -----
		/*
		 * contactRepositry.deleteAll();
		 * System.out.println("All contacts have been deleted.");
		 * 
		 * contactRepositry.deleteAllById(null);
		 */
		
	}

}
