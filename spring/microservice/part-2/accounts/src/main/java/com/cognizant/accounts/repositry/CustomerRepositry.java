package com.cognizant.accounts.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.accounts.entity.Customer;

public interface CustomerRepositry extends JpaRepository<Customer, Long> {
	
	Optional<Customer> findByMobileNumber(String mobileNumber);

}
