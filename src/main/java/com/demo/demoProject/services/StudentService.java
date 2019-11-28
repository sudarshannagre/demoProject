package com.demo.demoProject.services;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.demo.demoProject.entity.Student;

public interface StudentService {

	public List<Student> getListOfStudents();
	
	public Student getStudentById(int id);
	
	public Student createStudent(Student student);
	
	public HttpStatus deleteStudent(int id);
	
	public boolean findById(int id);
	
	public Student updateStudent(Student student);
	
	public List<Student> searchStudent(String name);
}
