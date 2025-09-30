package com.cognizant.cms;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cognizant.cms.model.Contact;
import com.cognizant.cms.repository.ContactRepository;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	private ContactRepository contactRepository;

	@Autowired
	public Application(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pageable pageable=Pageable.ofSize(5);
		Page<Contact> page=contactRepository.findAll(pageable);
		
	}

}
