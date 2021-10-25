package com.adi.graphql.resolver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adi.graphql.entity.Subject;
import com.adi.graphql.enums.SubjectNameFilter;
import com.adi.graphql.response.StudentResponse;
import com.adi.graphql.response.SubjectResponse;
import com.coxautodev.graphql.tools.GraphQLResolver;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

	public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse,
			SubjectNameFilter subjectNameFilter) {

		List<SubjectResponse> learningSubjects = new ArrayList<>();

		if (studentResponse.getStudent().getLearningSubjects() != null) {
			learningSubjects = new ArrayList<SubjectResponse>();
			for (Subject subject : studentResponse.getStudent().getLearningSubjects()) {
				if (subjectNameFilter.name().equalsIgnoreCase("All")) {
					learningSubjects.add(new SubjectResponse(subject));
				}
				else if (subjectNameFilter.name().equalsIgnoreCase(subject.getSubjectName())) {
					learningSubjects.add(new SubjectResponse(subject));
				}
			}
		}

		return learningSubjects;
	}

	public String getFullName(StudentResponse studentResponse) {
		return studentResponse.getFirstName() + " " + studentResponse.getLastName();

	}

}
