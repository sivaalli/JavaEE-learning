package com.source.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		//Person person = (Person) context.getBean("asjdb");
		Person per = (Person) context.getBean("person");
		per.speak();
		
		((ClassPathXmlApplicationContext) context).close();
		
	}
}
