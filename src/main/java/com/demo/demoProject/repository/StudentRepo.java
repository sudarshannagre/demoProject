package com.demo.demoProject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoProject.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>,CrudRepository<Student, Integer>{

	//@Query("from Student where name=?1 or mobileNo=?1 or className=?1 or branchName=?1")
	@Query("from Student where name like ?1 or mobileNo like ?1 or branchName like ?1")
	public List<Student> searchStudent(String name);
}
