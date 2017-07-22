package com.naturalprogrammer.spring5tutorial.commands;

import java.util.Collection;
import java.util.HashSet;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.naturalprogrammer.spring5tutorial.domain.User;
import com.naturalprogrammer.spring5tutorial.domain.User.Role;
import com.naturalprogrammer.spring5tutorial.validation.Password;
import com.naturalprogrammer.spring5tutorial.validation.UniqueEmail;

public class UserCommand {
	
	@UniqueEmail
	private String email;
	
	@NotBlank
	@Size(min=1, max=100)
	private String name;
	
	@Password
	private String password;
	
	private Collection<Role> roles = new HashSet<Role>();
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Collection<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
	public User toUser() {
		
		User user = new User();
		
		user.setEmail(email);
		user.setName(name);
		user.setPassword(password);
		
		return user;
	}
}
