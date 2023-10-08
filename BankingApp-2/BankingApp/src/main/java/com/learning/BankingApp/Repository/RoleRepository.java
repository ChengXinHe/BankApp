package com.learning.BankingApp.Repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.springjwt.models.ERole;
import com.demo.springjwt.models.Role;
import com.learning.BankingApp.Common.constants.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(Roles name);
