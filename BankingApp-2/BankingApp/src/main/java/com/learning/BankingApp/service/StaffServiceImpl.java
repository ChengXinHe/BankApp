package com.learning.BankingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.BankingApp.Model.Account;
import com.learning.BankingApp.Model.Staff;
import com.learning.BankingApp.Repository.StaffRepository;

public class StaffServiceImpl implements StaffService {
	@Autowired
	private StaffRepository StaffRepository;
	
	
	//Getting all the customer accounts
	@Override
	public List<Account> fetchAllAccounts() {
		List<Account> AllAccounts = StaffRepository.findAll();
		return AllAccounts;
	}

	//getting the customer account by id
	@Override
	public Optional<Account> fetchAccStatementById(Integer Id) {
		return StaffRepository.findById(Id);
	}
	
}
