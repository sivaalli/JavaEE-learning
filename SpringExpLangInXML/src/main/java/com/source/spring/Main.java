package com.source.spring;

import java.sql.DriverManager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/source/spring/beans/beans.xml");
	
		Person person = (Person) context.getBean("person");
		Robot robot = (Robot)context.getBean("robot");
		
		robot.speak();
		System.out.println(person.getRandom());
		
	}
}
