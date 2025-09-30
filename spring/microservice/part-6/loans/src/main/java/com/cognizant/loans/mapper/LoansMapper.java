package com.cognizant.loans.mapper;

import com.cognizant.loans.dto.LoansDto;
import com.cognizant.loans.entity.Loans;

public class LoansMapper {

	public static LoansDto mapsToLoansDto(Loans loans,LoansDto loansDto) {
		
		loansDto.setAmountPaid(loans.getAmountPaid());
		loansDto.setLoanNumber(loans.getLoanNumber());
		loansDto.setLoanType(loans.getLoanType());
		loansDto.setMobileNumber(loans.getMobileNumber());
		loansDto.setOutstandingAmount(loans.getOutstandingAmount());
		loansDto.setTotalLoan(loans.getTotalLoan());
		return loansDto;
	}
	
	public static Loans mapsToLoans(LoansDto loansDto, Loans loans) {
		
		loans.setAmountPaid(loansDto.getAmountPaid());
		loans.setLoanNumber(loansDto.getLoanNumber());
		loans.setLoanType(loansDto.getLoanType());
		loans.setMobileNumber(loansDto.getMobileNumber());
		loans.setOutstandingAmount(loansDto.getOutstandingAmount());
		loans.setTotalLoan(loansDto.getTotalLoan());
		return loans;
	}
}
