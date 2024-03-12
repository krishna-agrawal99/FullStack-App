package com.blog.fullStack.service;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.fullStack.exception.StudentAlreadyExistsException;
import com.blog.fullStack.exception.StudentNotFoundException;
import com.blog.fullStack.model.Student;
import com.blog.fullStack.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class IsStudentService implements StudentService{

	
	private final StudentRepository studentRepository;
	
	@Override
	public Student addStudent(Student student) {
		
		if(studentAlreadyExists(student.getEmail())) {
			throw new StudentAlreadyExistsException(student.getEmail()+"already exists");
		}
		return studentRepository.save(student);
	}

	
	@Override
	public List<Student> getStudents() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student, Long id) {
		
		return studentRepository.findById(id).map(st->{
			st.setFirstName(student.getFirstName());
			st.setLastName(student.getLastName());
			st.setEmail(student.getEmail());
			st.setDepartment(student.getDepartment());
			return studentRepository.save(st);
		}).orElseThrow(()-> new StudentNotFoundException("Sorry, this student could not be found"));
	}


	@Override
	public Student getStudentId(Long id) {
		
		return studentRepository.findById(id)
				.orElseThrow(()-> new StudentNotFoundException("Sorry,student not be found this id:"+id));
	}

	@Override
	public void deleteStudent(Long id) {
		if(!studentRepository.existsById(id)) {
			throw new StudentNotFoundException("Sorry, student not found:");
			
		}
		studentRepository.deleteById(id);
		
	}
	
	private boolean studentAlreadyExists(String email) {
		return studentRepository.findByEmail(email).isPresent() ;
	}


}
