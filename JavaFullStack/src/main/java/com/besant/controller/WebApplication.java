package com.besant.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.besant.dao.DaoImpl;
import com.besant.model.Employee;

/**
 * Servlet implementation class WebApplication
 */
@WebServlet("/EmployeePortal")
public class WebApplication extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WebApplication() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Inside Web Application GET");
		String name = request.getParameter("ename");
		System.out.println(name);
		DaoImpl dao = new DaoImpl(); // data access object
		try (PrintWriter out = response.getWriter()) {
			Employee e = dao.getEmployee(name);
			System.out.println("Employee retrieved");
			System.out.println(e);
			if (e != null) {
				out.println(e.toString());
			}

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("Inside Web Application POST");
		String name = request.getParameter("ename");
		System.out.println(name);
		int id =Integer.valueOf(request.getParameter("eid"));
		double salary = Double.valueOf(request.getParameter("esalary"));
		int dept = Integer.valueOf(request.getParameter("edept")); 
		Employee e =new Employee(id,name,salary,dept);
		
		DaoImpl dao = new DaoImpl(); // data access object
//		try (PrintWriter out = response.getWriter()) {
			int t = dao.addEmployee(e);
			System.out.println("Employee retrieved");
			System.out.println(e);
			if (t != 0) {
//				out.println("Employee Registered Succesfully");
			}
//		}
		response.setContentType("text/html");
		RequestDispatcher r = request.getRequestDispatcher("Home.html");
		r.forward(request, response);
	}

}
