package com.cognizant.loans.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.loans.entity.Loans;



@Repository
public interface LoansRepositry extends JpaRepository<Loans, Long> {
	
	Optional<Loans> findByMobileNumber(String mobileNumber);
	Optional<Loans> findByLoanNumber(String loanNumber);

}
