package com.example.demo.repository;

import com.example.demo.model.Student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
	 @Query(value = "select * from studentcrm s where s.name like %:keyword% or s.email like %:keyword%", nativeQuery = true)
	 public List<Student> search(@RequestParam("keyword") String keyword);
}
