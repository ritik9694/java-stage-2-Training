package com.cognizant.accounts.mapper;

import com.cognizant.accounts.dto.AccountsDto;
import com.cognizant.accounts.entity.Accounts;

public class AccountsMapper {

	public static AccountsDto mapToAccountDto(Accounts accounts, AccountsDto accountsDto) {
		accountsDto.setAccountNumber(accounts.getAccountNumber());
		accountsDto.setAccountType(accounts.getAccountType());
		accountsDto.setBranchAddress(accounts.getBranchAddress());
		return accountsDto;
		
	}
	
	public static Accounts mapToAccount(AccountsDto accountsDto, Accounts accounts) {
		accounts.setAccountNumber(accountsDto.getAccountNumber());
		accounts.setAccountType(accountsDto.getAccountType());
		accounts.setBranchAddress(accountsDto.getBranchAddress());
		return accounts;
		
	}
}
