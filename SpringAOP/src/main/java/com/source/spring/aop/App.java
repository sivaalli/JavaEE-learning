package com.source.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/source/spring/aop/xml/beans.xml");
	
		Camera camera = (Camera)context.getBean("camera");
		camera.snap();
		camera.snap("shiva",1.1);
		camera.dummy();
		
		context.close();
	}	 
  
}
