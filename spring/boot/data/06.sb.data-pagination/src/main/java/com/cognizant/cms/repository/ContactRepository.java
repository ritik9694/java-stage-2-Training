package com.cognizant.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.cms.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
   
}
