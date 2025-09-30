package com.cognizant.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {

	List<Contact> findByOrderByContactName();

	List<Contact> findByOrderByContactNameAsc();

	List<Contact> findByOrderByContactNameDsc();

}
