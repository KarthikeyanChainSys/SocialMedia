package com.chainsys.socialmedia.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Login {
	@Email(message = "*Email is not valid")
	@NotEmpty(message = "*Please enter email")
	private String email;
	
	@Size(max = 20, min = 8, message = "*Password length should be 8 to 20")
	@NotBlank(message = "*Password can't be Empty")
	@Pattern(regexp = "^[A-Za-z]\\w{3,20}$", message = "*Enter valid password ")
	private String password;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
