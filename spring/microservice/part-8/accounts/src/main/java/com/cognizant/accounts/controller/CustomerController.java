package com.cognizant.accounts.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.accounts.dto.AccountsContactInfoDto;
import com.cognizant.accounts.dto.CustomerDetailsDto;
import com.cognizant.accounts.service.CustomersDetailsService;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class CustomerController {
	
	@Autowired
    private AccountsContactInfoDto accountsContactInfoDto;
	
	private final CustomersDetailsService customersDetailsService;
	public CustomerController(CustomersDetailsService customersDetailsService) {
		this.customersDetailsService=customersDetailsService;
	}
	
	@GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDto> getContactInfo(){
    	return ResponseEntity.status(HttpStatus.OK)
			     .body(accountsContactInfoDto);
    }

	@GetMapping("/fetchCustomerDetails")
	public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam String mobileNumber){
		CustomerDetailsDto customerDetailsDto=customersDetailsService.fetchCustomerDetails(mobileNumber);
		return ResponseEntity.status(HttpStatus.OK).body(customerDetailsDto);
		
	}
}
