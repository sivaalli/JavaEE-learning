package com.source.HibernateOneToOne;

import javax.persistence.GeneratedValue;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter; 
import javax.persistence.*;

@Entity
@Table(name="studentdetials")
public class StudentDetails {
	
	@Id
	@GeneratedValue(generator="newGenerator")
	@GenericGenerator(name="newGenerator", strategy="foreign", parameters={
			@Parameter(name="property" ,value="student")})
	private int student_id;
	
		
	private String cell_number;
	
	@OneToOne //insert,update,delete , ALL
	@JoinColumn(name="student_id")
	private Student student;
	
	StudentDetails(){
		
	}
	 
	public StudentDetails(String cell_number,Student student){
		this.cell_number=cell_number;
		this.student=student;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getCell_number() {
		return cell_number;
	}

	public void setCell_number(String cell_number) {
		this.cell_number = cell_number;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}
