package com.source;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="student_details")
public class Student {
	
	@Column(name="id")
	@Id
	@GeneratedValue
	private int studentId;
	
	@Column(name="name")
	private String studentName;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	
	private String address;

	Student(){
		
	}
	
	public Student(int studentId, String studentName, Date dob, String address){
		this.studentId=studentId;
		this.address=address;
		this.dob=dob;
		this.studentName=studentName;
	}
	
	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

}
