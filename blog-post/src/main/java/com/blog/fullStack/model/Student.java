package com.blog.fullStack.model;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="student-blogs")
public class Student {
  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
   
   
	private String firstName;
  
	private String lastName;
	@NaturalId(mutable= true)
	private String email;
	
	private String department;
}
