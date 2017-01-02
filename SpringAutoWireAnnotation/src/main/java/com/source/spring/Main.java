package com.source.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/source/spring/beans/beans.xml");
		
		Logger logger = (Logger) context.getBean("logger");
		logger.writeConsoleWriter();
		logger.writeLogWriter();
		
		((ClassPathXmlApplicationContext)context).close();
	}

	
	
}
