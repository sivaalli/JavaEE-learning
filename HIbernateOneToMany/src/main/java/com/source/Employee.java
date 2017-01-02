package com.source;
//FOR GOOD TUTORIAL REFER : http://websystique.com/hibernate/hibernate-many-to-one-bidirectional-annotation-example/
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	@Id
	@GeneratedValue
	@Column(name="employee_id")
	private int EmployeeId;
	
	@Column(name="employee_name")
	private String EmployeeName;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="city_id")
	private City city;
	public int getEmployeeId() {
		return EmployeeId;
	}
	
	Employee(){
		
	}
	
	public Employee(String EmployeeName,City city){
		this.EmployeeName=EmployeeName;
		this.city=city;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	
	
	
}
