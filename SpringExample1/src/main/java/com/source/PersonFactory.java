package com.source;

public class PersonFactory {

		public Person createPerson(int id,String name){
			return new Person(id, name);
		}
}
