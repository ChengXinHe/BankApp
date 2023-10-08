package com.learning.BankingApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learning.BankingApp.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Object> {

}

