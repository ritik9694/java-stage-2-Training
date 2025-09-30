package com.cognizant.accounts.service;

import com.cognizant.accounts.dto.CustomerDetailsDto;

public interface CustomersDetailsService {

	CustomerDetailsDto fetchCustomerDetails(String mobileNumber);
}
