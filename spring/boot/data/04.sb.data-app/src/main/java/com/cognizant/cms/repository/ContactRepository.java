package com.cognizant.cms.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

	Optional<Contact> findByContactName(String cname);
   
    Contact findByContactNumber(String cno);
	
	Optional<Contact> findByContactNameAndContactNumber(String cname, String cno);
	
	List<Contact> findByContactNameOrContactNumber(String cname, String cno);
}
