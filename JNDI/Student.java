package com.shiva.jndi;

import java.io.Serializable;
	//we have to implement Serializable because while sending object through wire it converts object into 
	//bytestream. so in order for JVM to convert object to byte stream it has to implement Serializable
public class Student implements Serializable{
	 String name;
	 String id;
	 String grade;
	String address;
	int standard;
	Student(String name,String id,String grade,String address,int standrad){
		this.name=name;
		this.id=id;
		this.grade=grade;
		this.address=address;
		this.standard=standrad;
	}
}
