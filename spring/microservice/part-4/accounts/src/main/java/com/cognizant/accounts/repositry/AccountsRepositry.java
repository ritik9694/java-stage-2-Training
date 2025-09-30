package com.cognizant.accounts.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import com.cognizant.accounts.entity.Accounts;

import jakarta.transaction.Transactional;

public interface AccountsRepositry extends JpaRepository<Accounts, Long> {
	
	Optional<Accounts> findByCustomerId(Long customerID);
	
	@Transactional
	@Modifying
	void deleteByCustomerId(Long customerId);

}
