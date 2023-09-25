package com.learning.BankingApp.Model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Staff")
@NoArgsConstructor
@AllArgsConstructor(staticName="build")
@Data
public class Staff {
	@Id
	private Integer staffId;
	private String staffName;
	private Integer staffAge;
	private Double salary;
	private String address;
}
