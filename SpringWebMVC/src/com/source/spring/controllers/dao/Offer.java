package com.source.spring.controllers.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name="offers")
public class Offer {
	
	@Id
	@GeneratedValue
	private int id;
	
	//not using any more
/*	@Size(min=5, max=50)
	private String name;
	
	@NotNull
	//@Pattern(regexp=".*\\@.*\\..*", message="Not a valid email address")
	@ValidEmail(min=6)
	private String email;*/
	
	
	@ManyToOne
	@JoinColumn(name="username")
	private User user;
	

	@Size(min=5, max=50)
	private String text;
	
	public Offer(){
		this.user = new User();
	}
	
	public Offer(User user, String text) {
		this.user=user;
		this.text = text;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	public String getUsername(){
		return user.getUsername();
	}
	@Override
	public String toString() {
		return "Offer [user=" + user + ", text=" + text + "]";
	}
	
	
}
