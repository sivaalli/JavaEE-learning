package com.source;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course_student")
public class Course {
	
	@Id @GeneratedValue @Column(name="course_id")
	private int CourseId;
	
	@Column(name="course_name")
	private String CourseName;
	
	@ManyToMany(cascade=CascadeType.ALL)
	private Set<Student> studentSet = new HashSet<Student>();
	
	Course(){
		
	}
	
	public Course(String CourseName){
		this.CourseName=CourseName;
	}

	public int getCourseId() {
		return CourseId;
	}

	public void setCourseId(int courseId) {
		CourseId = courseId;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public Set<Student> getStudentSet() {
		return studentSet;
	}

	public void setStudentSet(Set<Student> studentSet) {
		this.studentSet = studentSet;
	}
	
	
	
}
