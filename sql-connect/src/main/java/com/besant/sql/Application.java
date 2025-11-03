package com.besant.sql;

import java.sql.SQLException;
import java.util.List;

import com.besant.dao.DaoImpl;
import com.besant.model.Employee;

public class Application {

	public static void main(String[] args) throws SQLException  {
		DaoImpl dao= null; //data access object
		try {
			dao= new DaoImpl(); //data access object
			List<Employee> employees=dao.getEmployees();
			employees.forEach(System.out::println);
			
			Employee e = dao.getEmployee();
			
			System.out.println("Employee :");
			System.out.println(e.toString());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}