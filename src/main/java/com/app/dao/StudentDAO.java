package com.app.dao;

import java.util.List;

import com.app.bean.Student;

public interface StudentDAO {

	boolean registerStudent(Student s);
	List<Student> getAllStudents();
}
