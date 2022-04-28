package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService {

	 private final StudentRepository studentRepository;

	    public StudentServiceImpl(StudentRepository studentRepository) {
	        this.studentRepository = studentRepository;
	    }
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		  return studentRepository.findAll();
	}

	@Override
	public Student createStudent(Student student) {
		return  studentRepository.save( student);
	}

	@Override
	public void deleteStudent(int id) {
		 Student  student= studentRepository.findById(id).get();
		 studentRepository.delete( student);
		
	}

	@Override
	public Student findStudent(int theId) {
		 Student  student= studentRepository.findById(theId).get();
		return  student;
	}

	@Override
	public Student updateStudent(int id) {
		// TODO Auto-generated method stub
		 return   studentRepository.findById(id).get();
	}
	@Override
	 public List<Student> listAll(String keyword) {
	        if (keyword != null) {
	            return studentRepository.search(keyword);
	        }
	        return studentRepository.findAll();
	    }

}
