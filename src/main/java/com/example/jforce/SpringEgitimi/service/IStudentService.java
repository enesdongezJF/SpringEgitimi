package com.example.jforce.SpringEgitimi.service;

import com.example.jforce.SpringEgitimi.modal.Student;
import com.example.jforce.SpringEgitimi.modal.StudentResponse;

import java.util.List;

public interface IStudentService {

	public List<Student> getStudentList();
	
	public Student getStudentById(Integer id);
	
	public StudentResponse save(Student student);
	
	public StudentResponse update(Integer id,String name);
	
	public StudentResponse delete(Integer id);
}
