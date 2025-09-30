package com.cognizant.accounts.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.cognizant.accounts.constant.AccountConstant;
import com.cognizant.accounts.dto.AccountsDto;
import com.cognizant.accounts.dto.CustomerDto;
import com.cognizant.accounts.entity.Accounts;
import com.cognizant.accounts.entity.Customer;
import com.cognizant.accounts.exception.CustomerAlreadyExistsException;
import com.cognizant.accounts.exception.ResourceNotFoundException;
import com.cognizant.accounts.mapper.AccountsMapper;
import com.cognizant.accounts.mapper.CustomerMapper;
import com.cognizant.accounts.repositry.AccountsRepositry;
import com.cognizant.accounts.repositry.CustomerRepositry;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountsService {

	private AccountsRepositry accountsRepositry;
	private CustomerRepositry customerRepositry;
	
	@Override
	public void createAccount(CustomerDto customerDto) {
		Optional<Customer> optionalCust = customerRepositry.findByMobileNumber(customerDto.getMobileNumber());
		if(optionalCust.isPresent()) {
			throw new CustomerAlreadyExistsException("Customer alreadyregistered with given mobileNumber " + customerDto.getMobileNumber());
		}

		Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
		Customer savedCustomer = customerRepositry.save(customer);
		
		accountsRepositry.save(createNewAccount(savedCustomer));
		
	}
	
	private Accounts createNewAccount(Customer customer) {
		Accounts newAccount = new Accounts();
		newAccount.setCustomerId(customer.getCustomerId());
		long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

		newAccount.setAccountNumber(randomAccNumber);
		newAccount.setAccountType(AccountConstant.SAVINGS);
		newAccount.setBranchAddress(AccountConstant.ADDRESS);
		return newAccount;
	}

	@Override
	public CustomerDto fetchAccount(String mobileNumber) {
		 Customer customer = customerRepositry.findByMobileNumber(mobileNumber).orElseThrow(
	                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
	        );
	        Accounts accounts = accountsRepositry.findByCustomerId(customer.getCustomerId()).orElseThrow(
	                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
	        );
	        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer, new CustomerDto());
	        customerDto.setAccountDto(AccountsMapper.mapToAccountDto(accounts, new AccountsDto()));
	        return customerDto;
	}

	@Override
	public boolean updateAccount(CustomerDto customerDto) {
		 boolean isUpdated = false;
	        AccountsDto accountsDto = customerDto.getAccountDto();
	        if(accountsDto !=null ){
	            Accounts accounts = accountsRepositry.findById(accountsDto.getAccountNumber()).orElseThrow(
	                    () -> new ResourceNotFoundException("Account", "AccountNumber", accountsDto.getAccountNumber().toString())
	            );
	            AccountsMapper.mapToAccount(accountsDto, accounts);
	            accounts = accountsRepositry.save(accounts);

	            Long customerId = accounts.getCustomerId();
	            Customer customer = customerRepositry.findById(customerId).orElseThrow(
	                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
	            );
	            CustomerMapper.mapToCustomer(customerDto,customer);
	            customerRepositry.save(customer);
	            isUpdated = true;
	        }
	        return  isUpdated;
	}

	@Override
	public boolean deleteAccount(String mobileNumber) {
		 Customer customer = customerRepositry.findByMobileNumber(mobileNumber).orElseThrow(
	                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
	        );
	        accountsRepositry.deleteByCustomerId(customer.getCustomerId());
	        customerRepositry.deleteById(customer.getCustomerId());
	        return true;
	}

}
