package com.cognizant.cms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.cognizant.cms.model.Contact;
import com.cognizant.cms.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	private ContactRepository contactRepository;

	@Autowired
	public ContactServiceImpl(ContactRepository contactRepository) {
		super();
		this.contactRepository = contactRepository;
	}

	@Override
	public List<Contact> getContactsInContactNameOrder() {
		/*
		List<Contact> contacts = contactRepository.findAll();
		return contacts;s
		*/
		
		// -- USING Find byOrderBy -- approach - 1
				//List<Contact> contacts = contactRepository.findByOrderByContactName();
				//List<Contact> contacts = contactRepository.findByOrderByContactNameAsc();
				//List<Contact> contacts = contactRepository.findByOrderByContactNameDsc();
				//List<Contact> contacts = contactRepository.findByOrderByContactNameDscContactNumberAsc();
		
		//List<Contact> contacts = contactRepository.findAll(Sort.by("contactName"));
				//List<Contact> contacts = contactRepository.findAll(Sort.by("contactName").ascending());
				List<Contact> contacts = contactRepository.findAll(Sort.by("contactName").descending());
				//List<Contact> contacts = contactRepository.findAll(Sort.by("contactName", "contactNumber"));
				return contacts;
	}

	

	

}
