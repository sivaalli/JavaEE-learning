package com.source.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
public static void main(String[] args) {
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/source/spring/aop/beans.xml");
	
	Canon canon = (Canon)context.getBean("canon");
	canon.snap();
	((ICamera)canon).camera();
	
	Nikon nikon = (Nikon)context.getBean("nikon");
	nikon.snap();
	((ICamera)canon).camera();
	
	
	
	context.close();
}
}
