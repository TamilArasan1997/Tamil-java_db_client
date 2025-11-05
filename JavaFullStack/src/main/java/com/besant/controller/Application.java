package com.besant.controller;

import java.util.List;

import com.besant.dao.DaoImpl;
import com.besant.model.Employee;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoImpl dao = new DaoImpl(); // data access object
		
		List<Employee> employees = dao.getEmployees();
		employees.forEach(System.out::println);
	}

}
