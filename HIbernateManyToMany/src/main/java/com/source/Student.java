package com.source;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="student_course")
public class Student {
	
	@Id @GeneratedValue
	@Column(name="student_id")
	private int StudentId;
	
	@Column(name="student_name")
	private String StudentName;
	
	//Hibernate is confusing. Here unline ManyToOne mappedBy should be the set in other class
	//but now this class name itself
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="studentSet") 
	private Set<Course> courseSet=new HashSet<Course>();
	
	Student(){
		
	}

	public Student(String name){
		this.StudentName=name;
	}
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public Set<Course> getCourseSet() {
		return courseSet;
	}
	public void setCourseSet(Set<Course> courseSet) {
		this.courseSet = courseSet;
	}
	
}
