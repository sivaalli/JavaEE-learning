package com.source.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Person {

	private String[] persons={"shiva","manohar","kaladhar"};

	
	public String getRandom(){
		Random rand = new Random();
	
		//return random string from list of persons
		return persons[rand.nextInt(persons.length)];
	}
}
