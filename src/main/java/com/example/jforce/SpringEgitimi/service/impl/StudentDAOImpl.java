package com.example.jforce.SpringEgitimi.service.impl;

import com.example.jforce.SpringEgitimi.modal.Student;
import com.example.jforce.SpringEgitimi.modal.StudentResponse;
import com.example.jforce.SpringEgitimi.repository.StudentRepository;
import com.example.jforce.SpringEgitimi.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentDAOImpl implements IStudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		return studentRepository.findById(id);
	}

	@Override
	public StudentResponse save(Student student) {
		StudentResponse studentResponse = null;
		try {
			studentRepository.save(student);
			studentResponse = new StudentResponse("Öğrenci Eklendi");

		} catch (Exception e) {
			System.out.println("Öğrenci eklenirken hata olustu : " + e.getMessage());
			studentResponse = new StudentResponse("Öğrenci eklenirken hata olustu : " + e.getMessage());
		}
		return studentResponse;
	}

	@Override
	public StudentResponse update(Integer id,String name) {
		StudentResponse studentResponse = null;
		try {
			Student tempStudent=studentRepository.findById(id);
			tempStudent.setFirstName(name);
			studentRepository.save(tempStudent);
			studentResponse = new StudentResponse("Öğrenci Güncellendi.");
		} catch (Exception e) {
			System.out.println("Öğrenci güncellenirken hata olustu :" +e.getMessage());
			studentResponse = new StudentResponse("Öğrenci güncellenirken hata olustu : " + e.getMessage());
		}
		return studentResponse;
	}

	@Override
	public StudentResponse delete(Integer id) {
		StudentResponse studentResponse = null;
		try {
			Student tempStudent=studentRepository.findById(id);
			studentRepository.delete(tempStudent);
			studentResponse = new StudentResponse("Öğrenci silindi");
		} catch (Exception e) {
			System.out.println("Öğrenci silinirken hata olustu : " + e.getMessage());
			studentResponse = new StudentResponse("Öğrenci silinirken hata olustu : " + e.getMessage());
		}
		return studentResponse;
	}

}
