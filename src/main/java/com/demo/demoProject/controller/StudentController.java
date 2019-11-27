package com.demo.demoProject.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.demoProject.dto.StudentDTO;
import com.demo.demoProject.entity.Student;
import com.demo.demoProject.exception.RecordNotFoundException;
import com.demo.demoProject.services.StudentService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/student")
public class StudentController {

	private Logger LOGGER = LogManager.getLogger(StudentController.class);

	@Autowired
	private StudentService studentService;

	@Autowired
	private ObjectMapper mapper;

	@GetMapping()
	public ResponseEntity<List<Student>> getListOfStudent() {
		LOGGER.info("testing log.....");
		return new ResponseEntity<>(studentService.getListOfStudents(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<StudentDTO> getStudentById(@PathVariable int id) {
		
		if(studentService.findById(id)) {
		StudentDTO dto = mapper.convertValue(studentService.getStudentById(id), StudentDTO.class);
		return new ResponseEntity<>(dto, HttpStatus.OK);}else {
			throw new RecordNotFoundException("No record found for id : "+id);
		}
	}

	@PostMapping()
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		
		if(studentService.findById(id)) {
			return new ResponseEntity<>(studentService.deleteStudent(id));
		}else {
			throw new RecordNotFoundException("No record found for id : "+id);
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@RequestParam String branchName, @RequestParam String mobileNo,
			@RequestParam String className, @RequestParam String address, @PathVariable int id) {

		Student student = studentService.getStudentById(id);
		student.setAddress(address);
		student.setBranchName(branchName);
		student.setMobileNo(mobileNo);
		student.setClassName(className);
		return new ResponseEntity<Student>(studentService.updateStudent(student), HttpStatus.OK);
	}
}
