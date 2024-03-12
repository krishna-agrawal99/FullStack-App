package com.blog.fullStack.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.fullStack.model.Student;
import com.blog.fullStack.service.StudentService;

import lombok.RequiredArgsConstructor;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

	private final StudentService studentService;
	
	//add student
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
	

	// get all student
	@GetMapping("/getStudents")
	public ResponseEntity<List<Student>> getStudents(){
		return new ResponseEntity<>(studentService.getStudents(),HttpStatus.FOUND);
	}
	
	//update student
	@PutMapping("updateStudent/{id}")
	public Student updateStudent(@RequestBody Student student,@PathVariable Long id) {
		return studentService.updateStudent(student, id);
	}
	
	// delete method
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		
	}
	
	@GetMapping("studentId/{id}")
	public Student getStudentById(@PathVariable Long id) {
		return studentService.getStudentId(id);
	}
	
	
	
	
	
	
	
}
