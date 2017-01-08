package com.source.spring.controllers.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.source.spring.controllers.validation.ValidEmail;

@Entity
@Table(name="users")
public class User {

	@NotBlank // can use @NotNull
	@Size(min = 4, max = 40)
	@Pattern(regexp = "^\\w{8,}$")
	@Id
	private String username;

	@ValidEmail
	private String email;
	
	@NotBlank // can use @NotNull
	@Size(min = 2, max = 40)
	private String name;

	@Transient
	@NotBlank()
	@Pattern(regexp = "^\\S+$")
	@Size(min = 8, max = 15)
	private String password;
	
	@Column(name="password")
	private String encodedPass;
		
	public String getEncodedPass() {
		return encodedPass;
	}

	public void setEncodedPass(String encodedPass) {
		this.encodedPass = encodedPass;
	}

	private String authority;
	private boolean enabled = false;

	public User() {

	}

	public User(String username, String email, String name,String password, String authority, boolean enabled) {
		this.username = username;
		this.email = email;
		this.name=name;
		this.password = password;
		this.authority = authority;
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	//@Transient
	public String getPassword() {
		return password;
	}

	//@Transient
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", email=" + email + ", name=" + name + ", authority=" + authority
				+ ", enabled=" + enabled + "]";
	}
	



}
