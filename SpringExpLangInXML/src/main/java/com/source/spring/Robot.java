package com.source.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	private String id;
	private String name;
	
	@Autowired
	public Robot(@Value("#{person.getRandom()?.length()}") String id, @Value("#{person? .getRandom()}") String name) {
		this.id = id;
		this.name = name;
	}
	
	public void speak(){
		System.out.println(id+"  "+name);
	}
	
}
