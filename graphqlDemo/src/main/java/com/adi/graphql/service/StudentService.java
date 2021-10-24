package com.adi.graphql.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.graphql.entity.Student;
import com.adi.graphql.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentById (long id) {
		return studentRepository.findById(id).get();
	}
}
