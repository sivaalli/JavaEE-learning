package com.source;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="city")
public class City {
	
	@Id
	@Column(name="city_id")
	@GeneratedValue
	private int CityId;
	
	@Column(name="city_name")
	private String CityName;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="city")
	private Set<Employee> employeeSet = new HashSet<Employee>();
	
	City(){
		
	}
	
	public City(String CityName){
		this.CityName=CityName;
	}
	
	public int getCityId() {
		return CityId;
	}
	public void setCityId(int cityId) {
		CityId = cityId;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public Set<Employee> getEmployeeSet() {
		return employeeSet;
	}
	public void setEmployeeSet(Set<Employee> employeeSet) {
		this.employeeSet = employeeSet;
	}
	
	
	
}
