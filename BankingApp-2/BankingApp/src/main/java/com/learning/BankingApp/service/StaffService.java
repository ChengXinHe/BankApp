package com.learning.BankingApp.service;

import java.util.List;
import java.util.Optional;

import com.learning.BankingApp.Model.Account;

public interface StaffService {

	//List All Accounts to be approved
	public List<Account> fetchAllAccounts();
	//To get statement of particular account given the account id
	public Optional<Account> fetchAccStatementById(Integer Id);
	
	
	//To validate the staff should be able to login to the system with valid u.name & pwd
	
	//List All the beneficiary to be approved
	
	//Approve the beneficiary which were added by customer
	
	//Approve the list of accounts added by the customer so that the transaction can be done
	
	//List All Customer 
	
	//Enable or disable the customer, based on that the customer should be able to login
	
	//Get customer with the id
	
	//To transfer the amount from one account to another account
	
}
