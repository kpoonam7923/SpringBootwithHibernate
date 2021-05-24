package com.myproject.demo.entities;


import javax.persistence.Embedded;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "employee")
public class Employee {
	
	@Id
	@GenericGenerator(name = "squ_id", strategy = "com.myproject.demo.customid.EmployeeIdGenerator")
	@GeneratedValue( generator = "squ_id")
	private String id;
	private String name;
	@Embedded
	private Address address;
	
	public Employee() {
		
	}
	public Employee(String name, Address address) {
		super();
		//this.id = id;
		this.name = name;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
	
	
	

}
