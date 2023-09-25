package com.learning.BankingApp.Model;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.learning.BankingApp.Common.constants.Active;

public class Beneficiary {

	private Integer BeneficiaryId;
	
	private Long customerId;
	private String BeneficiaryName;
	@Autowired
	private Active Active;
	private Date beneficiaryAddedDate;
	
	
}
