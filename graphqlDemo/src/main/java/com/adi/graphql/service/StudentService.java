package com.adi.graphql.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.graphql.entity.Address;
import com.adi.graphql.entity.Student;
import com.adi.graphql.entity.Subject;
import com.adi.graphql.repository.AddressRepository;
import com.adi.graphql.repository.StudentRepository;
import com.adi.graphql.repository.SubjectRepository;
import com.adi.graphql.request.CreateStudentRequest;
import com.adi.graphql.request.CreateSubjectRequest;


@Service
public class StudentService {
	

	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	SubjectRepository subjectRepository;
	

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudentById (long id) {
		return studentRepository.findById(id).get();
	}
	
	
	public Student createStudent (CreateStudentRequest createStudentRequest) {
		Student student = new Student(createStudentRequest);
		
		Address address = new Address();
		address.setStreet(createStudentRequest.getStreet());
		address.setCity(createStudentRequest.getCity());
		
		address = addressRepository.save(address);
		
		student.setAddress(address);
		student = studentRepository.save(student);
		
		List<Subject> subjectsList = new ArrayList<Subject>();
		
		if(createStudentRequest.getSubjectsLearning() != null) {
			for (CreateSubjectRequest createSubjectRequest : 
					createStudentRequest.getSubjectsLearning()) {
				Subject subject = new Subject();
				subject.setSubjectName(createSubjectRequest.getSubjectName());
				subject.setMarksObtained(createSubjectRequest.getMarksObtained());
				subject.setStudent(student);
				
				subjectsList.add(subject);
			}
			
			subjectRepository.saveAll(subjectsList);
			
		}
		
		student.setLearningSubjects(subjectsList);
		
		return student;
	}
}
