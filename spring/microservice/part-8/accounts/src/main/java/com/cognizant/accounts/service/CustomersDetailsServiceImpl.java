package com.cognizant.accounts.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cognizant.accounts.dto.AccountsDto;
import com.cognizant.accounts.dto.CardsDto;
import com.cognizant.accounts.dto.CustomerDetailsDto;
import com.cognizant.accounts.dto.LoansDto;
import com.cognizant.accounts.entity.Accounts;
import com.cognizant.accounts.entity.Customer;
import com.cognizant.accounts.exception.ResourceNotFoundException;
import com.cognizant.accounts.mapper.AccountsMapper;
import com.cognizant.accounts.mapper.CustomerMapper;
import com.cognizant.accounts.repositry.AccountsRepositry;
import com.cognizant.accounts.repositry.CustomerRepositry;
import com.cognizant.accounts.service.client.CardsFeignClient;
import com.cognizant.accounts.service.client.LoansFeignClient;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomersDetailsServiceImpl implements CustomersDetailsService {

	private AccountsRepositry accountsRepositry;
	private CustomerRepositry customerRepositry;
	
	private CardsFeignClient cardsFeignClient;
	private LoansFeignClient loansFeignClient;
	
	
	@Override
	public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
		Customer customer=customerRepositry.findByMobileNumber(mobileNumber).orElseThrow(
				() -> new ResourceNotFoundException("Customer","mobileNumber", mobileNumber)
				);
		Accounts accounts = accountsRepositry.findByCustomerId(customer.getCustomerId()).orElseThrow(
				() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
				);
		CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
		customerDetailsDto.setAccountDto(AccountsMapper.mapToAccountDto(accounts, new AccountsDto()));
		
		ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoansDetails(mobileNumber);
		customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
		
		ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
		customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
		
		return customerDetailsDto;
		
	}

}
