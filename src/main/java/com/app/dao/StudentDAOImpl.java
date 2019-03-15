package com.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.app.bean.Gender;
import com.app.bean.Student;
import com.app.exceptions.DuplicateIdException;

public class StudentDAOImpl implements StudentDAO {

	ConnectionFactory factory = new ConnectionFactory();
	
	
	public boolean registerStudent(Student s) throws DuplicateIdException {

		// insert query ...
		String query = "insert into university(uno,name,gender) values(?,?,?)";
		Connection conn = factory.getConnection();
		try {
						
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, s.getUno());
			stmt.setString(2, s.getName());
			stmt.setString(3, s.getGender().toString());

			int count = stmt.executeUpdate();

			if (count == 1) {
				System.out.println(count + "inserted record successfully");
				return true;
			}

		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
			
			throw new DuplicateIdException("Duplicate uno :" + s.getUno() + " is not allowed !!");
			
			
			
		} finally {
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		return false;
	}

	
	public List<Student> getAllStudents() {
	
		List<Student> students = new ArrayList<Student>();
		Connection conn = factory.getConnection();
		String query = "select * from university";
		try {
			Statement stmt = conn.createStatement();
			
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				Integer uno = rs.getInt("uno");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				
				Student s = new Student(uno.toString(), name, Gender.valueOf(gender));
				students.add(s);
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return students;
	}


	public void deleteStudent(int id) throws DuplicateIdException {
		Connection conn = factory.getConnection();
		String query = "delete from university where uno =" + id;

		System.out.println("Here we can write a query to delete the student using id");
	}

}
