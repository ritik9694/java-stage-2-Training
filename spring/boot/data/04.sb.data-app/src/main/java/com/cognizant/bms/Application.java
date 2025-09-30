package com.cognizant.bms;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.cognizant.cms.model.Contact;
import com.cognizant.cms.repository.ContactRepository;

@SpringBootApplication

@ComponentScan(basePackages = { "com.cognizant.bms", "com.cognizant.cms" })
@EnableJpaRepositories(basePackages = "com.cognizant.cms.repository")
@EntityScan(basePackages = "com.cognizant.cms.model")

public class Application implements CommandLineRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	static String projectName = "online bookstore";
	static int version = 12;

	private ContactRepository contactRepository;
	private Contact contact;

	@Autowired
	public Application(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	public static void main(String[] args) {
		LOGGER.info("initializing spring container");
		SpringApplication.run(Application.class, args);
		LOGGER.error("spring container initialized - {}, {}", projectName, version);
	}

	@Override
	public void run(String... args) throws Exception {
		String cname = "Ajay";
		String cno = "8574968596";

		Optional<Contact> optContact = contactRepository.findByContactName(cname);
		if (optContact.isPresent()) {
			contact = optContact.get();
			// LOGGER.info(contact.toString());
			LOGGER.info("Contact found: {}", contact);
		} else {
			LOGGER.error("no matching conact for contact Name: {}", cname);
		}
		System.out.println();

		// 2. Find by contact number
		contact = contactRepository.findByContactNumber(cno);
		if (contact != null) {

			LOGGER.info("Found by number: {}", contact);

		} else {
			LOGGER.warn("No contact found with number: {}", cno);
		}

		System.out.println();

		// 3. Find by name and number
		Optional<Contact> contactNameAndNumber = contactRepository.findByContactNameAndContactNumber(cname, cno);
		if (contactNameAndNumber.isPresent()) {
			LOGGER.info("Found by name and number: {}", contact);
		} else {
			LOGGER.warn("No contact found with name '{}' and number '{}'", cname, cno);
		}

		System.out.println();
		// 4. Find by name or number

		List<Contact> contactsByNameOrNumber = contactRepository.findByContactNameOrContactNumber(cname, cno);
		if (!contactsByNameOrNumber.isEmpty()) {
			LOGGER.info("Found {} contact(s) by name or number:", contactsByNameOrNumber.size());
			contactsByNameOrNumber.forEach(contact -> LOGGER.info(" - {}", contact));
		} else {
			LOGGER.warn("No contacts found with name '{}' or number '{}'", cname, cno);
		}

	}

}
