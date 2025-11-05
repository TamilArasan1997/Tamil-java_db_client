package com.besant.model;

public class Employee {
	private int employee_id;
	private String full_name;
	private double salary;
	private int department_id;
	
	public Employee(int employee_id, String full_name, double salary, int department_id) {
		super();
		this.employee_id = employee_id;
		this.full_name = full_name;
		this.salary = salary;
		this.department_id = department_id;
	}

	public Employee(String name, double salary, int dept) {
		// TODO Auto-generated constructor stub
		this.full_name = name;
		this.salary = salary;
		this.department_id = dept;
	}

	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", full_name=" + full_name + ", salary=" + salary
				+ ", department_id=" + department_id + "]";
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getDepartment_id() {
		return department_id;
	}

	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	
	
}
