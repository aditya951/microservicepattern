package com.adi.graphql.resolver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.graphql.resolver.entity.Student;
import com.adi.graphql.resolver.repository.StudentRepository;


@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentById (long id) {
		return studentRepository.findById(id).get();
	}
}
