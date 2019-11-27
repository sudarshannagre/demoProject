package com.demo.demoProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.demoProject.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>,CrudRepository<Student, Integer>{

}
