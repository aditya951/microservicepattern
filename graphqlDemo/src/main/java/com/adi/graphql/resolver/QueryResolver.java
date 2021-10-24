package com.adi.graphql.resolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.adi.graphql.model.SampleRequest;
import com.adi.graphql.response.StudentResponse;
import com.adi.graphql.service.StudentService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class QueryResolver implements GraphQLQueryResolver {
	
	@Autowired
	StudentService studentService;
	
	
	public String firstQuery0() {
		return "firstquery0 from resolver class";
	}

	public String firstQuery1() {
		return "firstquery1 from resolver class";
	}
	public String firstQuery2() {
		return "firstquery2 from resolver class";
	}
	public String firstQuery3() {
		return "firstquery3 from resolver class";
	}
	
	public String fullName(String first,String last) {
		return first+" "+last ;
	}
	
	
	public String fullName(SampleRequest sample) {
		return sample.getFirst()+" "+sample.getMiddle()+" "+sample.getLast() ;
	}
	  
	public StudentResponse getStudent(long id) {
		return new StudentResponse(studentService.getStudentById(id));
	}
	
	
}
