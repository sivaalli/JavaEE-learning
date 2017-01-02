package com.source.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
//@Component("asjdb")
public class Person {
	
	@Autowired
	@Value("3001")
	private int id;
	
	@Autowired
	@Value("shiva praneeth")
	private String name;
	
	/*@Autowired
	public void setId( @Value("2001") int id) {
		this.id = id;
	}
	
	@Autowired
	public void setName( @Value("shiva praneeth") String name) {
		this.name = name;
	}*/
	public void speak(){
		System.out.println(id+"  "+name);
	}
	
	
	
}
