package com.app.dao;

import java.util.List;

import com.app.bean.Student;
import com.app.exceptions.DuplicateIdException;

public interface StudentDAO {

	boolean registerStudent(Student s) throws DuplicateIdException;
	List<Student> getAllStudents();
	void deleteStudent(int id) throws DuplicateIdException;
}
