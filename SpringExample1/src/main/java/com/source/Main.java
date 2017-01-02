package com.source;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("com/source/beans/beans.xml");
		
		//created using factory pattern, person obj is created using factory.
		Person person = (Person) context.getBean("person");
		Person person2 = (Person) context.getBean("person2");
		System.out.println(person);
		System.out.println(person2);
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
