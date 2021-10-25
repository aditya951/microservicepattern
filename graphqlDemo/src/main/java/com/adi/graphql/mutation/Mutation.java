package com.adi.graphql.mutation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adi.graphql.request.CreateStudentRequest;
import com.adi.graphql.response.StudentResponse;
import com.adi.graphql.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Service
public class Mutation implements GraphQLMutationResolver {

	@Autowired
	StudentService studentService;
	
	public StudentResponse createStudent (CreateStudentRequest createStudentRequest) {
		return new StudentResponse(studentService.createStudent(createStudentRequest));
	}
}
