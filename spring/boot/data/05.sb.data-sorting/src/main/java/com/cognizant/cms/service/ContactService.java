package com.cognizant.cms.service;

import java.util.List;

import com.cognizant.cms.model.Contact;

public interface ContactService {

	public List<Contact> getContactsInContactNameOrder();
}
