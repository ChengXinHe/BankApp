package com.learning.BankingApp.Entity.Admin;


import com.learning.BankingApp.Common.constants.Roles;

public class AdminEntity {
    Integer adminid;
    String name;
    String email;
    Roles role = Roles.ROLE_ADMIN; //select from Roles enum

}
