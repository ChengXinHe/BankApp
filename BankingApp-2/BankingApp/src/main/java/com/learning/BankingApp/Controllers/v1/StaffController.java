package com.learning.BankingApp.Controllers.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.BankingApp.Model.Account;
import com.learning.BankingApp.service.StaffService;
import com.learning.BankingApp.service.StaffServiceImpl;

@RequestMapping("/api/staff/")
public class StaffController {
	StaffService staffService;
	
	//Replace return type with Account type
	@GetMapping("/account/:accountNo")
	private Optional<Account> getStatement(Integer accountNo)
	{
		return staffService.fetchAccStatementById(accountNo);
	}
	
	@GetMapping("/customer")
	private List<Account> getAllAccounts()
	{
		List<Account> AllAccounts  = staffService.fetchAllAccounts();
		return AllAccounts;
	}
	
	
	

}
