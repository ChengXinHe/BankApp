package com.learning.BankingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.BankingApp.Model.Account;
import com.learning.BankingApp.Model.Staff;

public interface StaffRepository extends JpaRepository<Account, Object> {
	
}
