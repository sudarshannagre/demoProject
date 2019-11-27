package com.demo.demoProject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.demo.demoProject.entity.Student;
import com.demo.demoProject.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public List<Student> getListOfStudents() {
		return studentRepo.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> student = studentRepo.findById(id);
		return student.isPresent() ? student.get() : null;
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public HttpStatus deleteStudent(int id) {
		studentRepo.deleteById(id);
		return HttpStatus.OK;
	}

	@Override
	public boolean findById(int id) {
		return studentRepo.existsById(id);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepo.save(student);
	}
}
