package com.learning.BankingApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Account")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {

	//The generic parts
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountNo;
	private String customerName;
	private Double balance;
		
	@Autowired
	private Transaction transaction;
	
}
