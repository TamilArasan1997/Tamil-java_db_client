package com.besant.dao;

import java.util.*;
import java.sql.*;
import com.besant.model.Employee;

public class DaoImpl {
	
	private String connection = "jdbc:mysql://localhost:3306/employee";// protocol jdbc:myql servername(ip) localhost 3306 port number
	private String username ="root";
	private String password = "tamil";
	
	public DaoImpl () {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Employee> getEmployees() {
		String query = "select * from employees";
		List<Employee>  list = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(connection,username,password);
				PreparedStatement psmt = conn.prepareStatement(query)){
			
			ResultSet r =psmt.executeQuery();
			
			while(r.next()) {
				
				System.out.println("Fetching row : "+r.getString(1));
				
				list.add(new Employee(r.getInt(1),r.getString(2),r.getDouble(3),r.getInt(4)));			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int addEmployee(Employee e) {
		String query = "insert into employees values (?,?,?,?)";
		int t =0;
		
		try(Connection conn = DriverManager.getConnection(connection,username,password);
				PreparedStatement psmt = conn.prepareStatement(query)){
			psmt.setInt(1,e.getEmployee_id() );
			psmt.setString(2, e.getFull_name());
			psmt.setDouble(3, e.getSalary());
			psmt.setInt(4, e.getDepartment_id());
			
			t =psmt.executeUpdate(); // executes and returns the no of rows affected
			
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}		
			
		return t;
	}

	public Employee getEmployee(String name) {
		String query = "select * from employees where full_name=?";
		Employee  e = null;
		
		try(Connection conn = DriverManager.getConnection(connection,username,password);
				PreparedStatement psmt = conn.prepareStatement(query)){
			psmt.setString(1, name);
			
			ResultSet r =psmt.executeQuery();
			
			if(r.next()) {
				
				System.out.println("Fetching row : "+r.getString(1));
				
				e=new Employee(r.getInt(1),r.getString(2),r.getDouble(3),r.getInt(4));			
			}else {
				System.out.println("employee not found");
			}
			
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}
		return e;
	}

	public int updateEmployee(int i, double d) {
		String query = "update employees set salary = ? where  employee_id=?";
		int t =0;
		
		try(Connection conn = DriverManager.getConnection(connection,username,password);
				PreparedStatement psmt = conn.prepareStatement(query)){
			psmt.setDouble(1,d);
			psmt.setInt(2,i);
	
			t =psmt.executeUpdate(); // executes and returns the no of rows affected
			
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}		
			
		return t;
	}

	public int deleteEmployee(int i) {
		String query = "delete from employees where employee_id=?";
		int t =0;
		
		try(Connection conn = DriverManager.getConnection(connection,username,password);
				PreparedStatement psmt = conn.prepareStatement(query)){
			psmt.setInt(1,i);
	
			t =psmt.executeUpdate(); // executes and returns the no of rows affected
			
		} catch (SQLException exp) {
			// TODO Auto-generated catch block
			exp.printStackTrace();
		}		
			
		return t;
	}

}
