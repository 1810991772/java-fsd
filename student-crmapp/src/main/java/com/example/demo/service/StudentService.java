package com.example.demo.service;

import com.example.demo.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudent();

    public Student createStudent(Student student);

    public void deleteStudent(int id);

	public Student findStudent(int theId);

	public Student updateStudent(int id);
	 public List<Student> listAll(String keyword);
}
