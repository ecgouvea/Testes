package com.javacodegeeks.examples.jaxb.validation.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Employee {
	private int employeeId;
	private String name;
	private Address address;
	private Double salary;

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Employee(int employeeId, String name, Address address, Double salary) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Employee() {
		super();
	}
}
