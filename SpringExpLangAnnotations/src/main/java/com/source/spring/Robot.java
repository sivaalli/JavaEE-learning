package com.source.spring;

import org.springframework.beans.factory.annotation.Value;

public class Robot {
	
	private String id;
	private String name;
	
	public Robot(String id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public void speak(){
		System.out.println(id+"  "+name);
	}
	
}
