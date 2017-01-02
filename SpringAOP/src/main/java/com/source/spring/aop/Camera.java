package com.source.spring.aop;

import org.springframework.stereotype.Component;

@Component("camera")
public class Camera{
	
	public Camera(){
		System.out.println("Camera constructor");
	}
	
	public void snap(){
		System.out.println("SNAP!!!");
	}
	
	public String snap(String name,double num){
		System.out.println("SNAP!!! "+name);
		System.out.println("SNAP!!! "+num);
		return name;
	}
	
	public void dummy(){
		System.out.println("dummy method invoked");
	}
}
