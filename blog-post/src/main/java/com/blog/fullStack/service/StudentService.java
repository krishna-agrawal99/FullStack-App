package com.blog.fullStack.service;

import java.util.List;

import com.blog.fullStack.model.Student;

public interface StudentService {

	Student addStudent(Student student);
	
	List<Student> getStudents();
	
	Student updateStudent(Student student,Long id);
	
	Student getStudentId(Long id);
	
	void deleteStudent(Long id);
}
