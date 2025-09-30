package com.cognizant.accounts.dto;

import lombok.Data;

@Data
public class CustomerDetailsDto {

	    private String name;
	    private String email;
	    private String mobileNumber;
	    
	    private AccountsDto accountDto;
	    
	    private CardsDto cardsDto;
	    private LoansDto loansDto;
}
