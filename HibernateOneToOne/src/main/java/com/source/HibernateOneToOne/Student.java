package com.source.HibernateOneToOne;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
	
	Student(){
		
	}
	public Student(String student_name){
		this.student_name=student_name;
	}
	@Id
	@GeneratedValue
	private int student_id;
	
	private String student_name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="student_id")
	private StudentDetails student_details;
	
	public StudentDetails getStudent_details() {
		return student_details;
	}
	public void setStudent_details(StudentDetails student_details) {
		this.student_details = student_details;
	}
	public int getStudent_id() {
		return student_id;
	}
	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}

	
}
