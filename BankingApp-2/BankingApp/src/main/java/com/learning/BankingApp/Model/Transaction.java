package com.learning.BankingApp.Model;
import java.sql.Date;

import com.learning.BankingApp.Common.constants.TransactionType;
public class Transaction {

	private Date date;
	private String reference;
	private Double amount;
	private TransactionType transactionType;
}
