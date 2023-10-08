package com.learning.BankingApp.Model;


import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Customer")
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class Customer {
	@Id
	private Integer customerId;
	private String userName;
	private String fullName;
	private String password;
}

