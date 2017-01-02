package com.source.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Person {

	private List<String> persons;

	public void setPersons(List<String> persons) {
		this.persons = persons;
	}
	
	public String getRandom(){
		Random rand = new Random();
		
		//return null;
		//return random string from list of persons
		return persons.get(rand.nextInt(persons.size()));
	}
}
