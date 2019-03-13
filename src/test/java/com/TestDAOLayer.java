package com;

import java.util.List;

import com.app.bean.Gender;
import com.app.bean.Student;
import com.app.dao.StudentDAO;
import com.app.dao.StudentDAOImpl;

import junit.framework.TestCase;

public class TestDAOLayer extends TestCase {

	StudentDAO dao = new StudentDAOImpl();
	
	public void test_GetAllStudents_NotNull_SizeNotZero() {
		List<Student> students = dao.getAllStudents();
		
		assertNotNull(students);
		
		int size = students.size();
		
		if(size != 0) {
			assertTrue(true);
		}else {
			assertTrue(false);
		}
		
	}
	

	public void test_GetAllStudents_Size() {
	
		List<Student> students = dao.getAllStudents();
		
		assertEquals(6,students.size());
	}
	
	public void test_GetAllStudents_content() {
		
		List<Student> students = dao.getAllStudents();
		
		Student s = students.get(0);
		
		assertEquals("1", s.getUno());
		assertEquals("Ashwin", s.getName());
		assertEquals(Gender.MALE, s.getGender());
		
		
	}
	
	
	
	
}
