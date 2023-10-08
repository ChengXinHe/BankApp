package com.learning.BankingApp.jwt.payload;

import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.*;


public class SignupRequest {
	@NotBlank
	  @Size(min = 3, max = 20)
	  private String username;

	  @NotBlank
	  @Size(min = 3, max = 50)
	  private String fullname;

	  @NotBlank
	  @Size(min = 6, max = 40)
	  private String password;

	  public String getUsername() {
	    return username;
	  }

	  public void setUsername(String username) {
	    this.username = username;
	  }

	  public String getFullName() {
	    return fullname;
	  }

	  public void setFullName(String fullname) {
	    this.fullname = fullname;
	  }

	  public String getPassword() {
	    return password;
	  }

	  public void setPassword(String password) {
	    this.password = password;
	  }

 
}
