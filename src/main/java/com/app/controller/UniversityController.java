package com.app.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.app.bean.Gender;
import com.app.bean.Student;
import com.app.dao.StudentDAO;
import com.app.dao.StudentDAOImpl;
import com.app.exceptions.DuplicateIdException;

@WebServlet("/controller")
public class UniversityController extends HttpServlet {
	
	Logger logger = Logger.getLogger(UniversityController.class);
	
	StudentDAO dao = new StudentDAOImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getParameter("action");
		
		logger.info(" Locale " + request.getLocale());
		logger.info(" Host " + request.getHeader("Host"));
		
		RequestDispatcher view = null;

		if (action.equals("register")) {
			logger.info("Request for registering a new student");
			view = request.getRequestDispatcher("Registration.jsp");
			view.forward(request, response);

		} else if (action.equals("list")) {
			
			
			//fetch the data from database
			List<Student> students = dao.getAllStudents();
			
			request.setAttribute("Studentdata", students);
			
			view = request.getRequestDispatcher("List.jsp");
			view.forward(request, response);

		} else if (action.equals("registernewstudent")) {
			logger.info("Received details for registering a new student");
			String uno = request.getParameter("uno");
			String name = request.getParameter("Name");
			String gender = request.getParameter("gender").toUpperCase();
			
			Student s = new Student(uno,name,Gender.valueOf(gender)); //converting string to enum value
																	  // MALE , Male				
			
			
			boolean status;
			try {
				status = dao.registerStudent(s);
				view = request.getRequestDispatcher("HomePage.jsp");
				view.forward(request, response);
				
			} catch (DuplicateIdException e) {
				
				logger.error(e.getMessage());
				
				request.setAttribute("errormessage", e.getMessage());
				
				view = request.getRequestDispatcher("Registration.jsp");
				view.forward(request, response);
				
				
			}
			
			
			
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
