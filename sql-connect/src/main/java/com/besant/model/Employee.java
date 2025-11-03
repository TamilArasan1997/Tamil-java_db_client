package com.besant.model;

public class Employee {

	private String id;
	private String name;
	private String salary;
	public Employee(String id, String name, String salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
