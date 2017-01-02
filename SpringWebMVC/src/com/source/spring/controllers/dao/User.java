package com.source.spring.controllers.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.source.spring.controllers.validation.ValidEmail;

public class User {

	@NotBlank // can use @NotNull
	@Size(min = 4, max = 15)
	@Pattern(regexp = "^\\w{8,}$")
	private String username;

	@ValidEmail
	private String email;

	@NotBlank()
	@Pattern(regexp = "^\\S+$")
	@Size(min = 8, max = 15)
	private String password;
	private String authority;
	private boolean enabled = false;

	public User() {

	}

	public User(String username, String email, String password, String authority, boolean enabled) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.authority = authority;
		this.enabled = enabled;
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

	public String getPassword() {
		return password;
	}

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
		return "User [username=" + username + ", email=" + email + ", password=" + password + ", authority=" + authority
				+ ", enabled=" + enabled + "]";
	}

}
