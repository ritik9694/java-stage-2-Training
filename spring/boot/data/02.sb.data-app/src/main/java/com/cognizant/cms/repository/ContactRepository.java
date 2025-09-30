package com.cognizant.cms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.model.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {
   
}
