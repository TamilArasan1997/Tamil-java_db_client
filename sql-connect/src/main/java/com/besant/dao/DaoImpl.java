package com.besant.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.besant.model.*;

public class DaoImpl {
	private String connection ="jdbc:mysql://localhost:3306/employee";//protocol:sub-protocol:data-source
    private String username = "root";
    private String password = "tamil";	
    
	public DaoImpl () throws ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");		    
	}
	
	public List<Employee> getEmployees() throws SQLException {
		String 	query="select * from employees";
		List<Employee> list = new ArrayList<>();
		try(Connection conn = DriverManager.getConnection(connection,username,password); 
				PreparedStatement psmt = conn.prepareStatement(query)){
			ResultSet r = psmt.executeQuery();
			
			while(r.next()) {
				System.out.println(r.getString(1));
				list.add(new Employee(r.getString(1),r.getString(2),r.getString(3)));
			}
			
		};
		return list;		
	}

	public Employee getEmployee(int i) {
		String query = "select * from employees where employee_id=?";
		Employee e = null;
		try(Connection conn = DriverManager.getConnection(connection,username,password);
			PreparedStatement psmt = conn.prepareStatement(query)){
			psmt.setInt(1,i);
			
			ResultSet r = psmt.executeQuery();
			
			if(r.next()) {
				e = new Employee(r.getString(1),r.getString(2),r.getString(3));
			}else {
				System.out.println("Employee not found : 404");
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return e;
	}

	public int addEmployee(Employee e) {
		String query = "insert into employees values (?,?,?,?)";
		int t = 0;
		try(Connection conn = DriverManager.getConnection(connection,username,password);
				PreparedStatement psmt = conn.prepareStatement(query)){
				psmt.setString(1,e.getId());
				psmt.setString(2, e.getName());
				psmt.setString(3, e.getSalary());
				psmt.setString(4,"107");
				
				t = psmt.executeUpdate();
				

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		return t;
	}

	public int removeEmployee(int i) {
		String query = "DELETE FROM employees WHERE employee_id = ?";
		int t = 0;
		try(Connection conn = DriverManager.getConnection(connection,username,password);
				PreparedStatement psmt = conn.prepareStatement(query)){
				psmt.setInt(1,i);
		
				t = psmt.executeUpdate();
				

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
						
			}
		return t;
	}
}
