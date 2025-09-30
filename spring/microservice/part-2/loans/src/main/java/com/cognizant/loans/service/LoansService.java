package com.cognizant.loans.service;

import java.util.Optional;

import com.cognizant.loans.dto.LoansDto;
import com.cognizant.loans.entity.Loans;

public interface LoansService {
	
	void createLoan(String mobileNumber);
	LoansDto fetchLoan(String Number);
	boolean updateLoan(LoansDto loansDto);
	boolean deleteLoan(String mobileNumber);

}
